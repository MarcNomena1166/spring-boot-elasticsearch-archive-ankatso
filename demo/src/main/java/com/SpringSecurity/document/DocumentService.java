package com.SpringSecurity.document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.AbstractElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Service
public class DocumentService {

	@Autowired
	AbstractElasticsearchTemplate est;
	
	DocumentESRepository desr;
	

	@Autowired
	public DocumentService(DocumentESRepository desr) {
		this.desr = desr;
	}

	public void insertDoc(Document d)
	{
		System.out.println("insert ES :"+d.getAuteur());
		this.desr.save(d);
	}
	

	public void deleteDoc(int id)
	{
		this.desr.deleteById(id);
	}
	
	public List<Document> getDocuments()
	{
		Iterable<Document> doc=this.desr.findAll();
		 List<Document> list = StreamSupport
                 .stream(doc.spliterator(), false)
                 .collect(Collectors.toList());
		 
		 return list;
		
	}
	
	public String extractTextPDF(File f) throws Exception
	{
		PDDocument pdDoc=PDDocument.load(f);
		PDFTextStripper pdftripper=new PDFTextStripper();
		String texte=pdftripper.getText(pdDoc);
		pdDoc.close();
		
		return texte;
	}
	
	public List<String> splitMocla(String mots_cles)
	{
		String[] mocla=mots_cles.split(",");
		List<String> retour=new ArrayList<String>();
		for(int i=0;i<mocla.length;i++)
			retour.add(mocla[i]);
		return retour;
	}
	
	public void updateDocumentES(Document doc)
	{
		this.desr.deleteById(doc.getId());
		this.desr.save(doc);
	}
	
	public Document getDocByid(int id)
	{
		return this.desr.findById(id).get();
	}
	
	public List<Document> FilterDocument(String text,String field)
	{
		if(text.lastIndexOf(" ")==text.length()-1)text=text.trim();		
		if(text.contains(" "))return this.getDocumentFilter(text, field);
		return this.getDocFilter(text, field);
	}
	
	public List<Document> getDocFilter(String text,String field)
	{
		FuzzyQueryBuilder query=QueryBuilders.fuzzyQuery(field, text);
		NativeSearchQuery qB =new NativeSearchQueryBuilder()
				.withQuery(query)
				.build();
		
		
		SearchHits<Document> searchHits  =est.search(qB, Document.class);
		
		 return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	public List<Document> getDocumentFilter(String text,String field)
	{
		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.queryStringQuery(text)
				.lenient(true)
				.field(field)
				.fuzziness(Fuzziness.AUTO)
						);
			//	.should(QueryBuilders.queryStringQuery("*."+text+".*")
				//		.fuzziness(Fuzziness.AUTO)
					//	
					//	);
		
		NativeSearchQuery qB =new NativeSearchQueryBuilder()
				.withQuery(query)
				.build();
		
		SearchHits<Document> searchHits  =est.search(qB, Document.class);
		
		 return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	public List<Document> AdvancedFind(String titre,String auteur,String contenu)
	{
		BoolQueryBuilder query = QueryBuilders.boolQuery();
		if(!titre.isBlank())
		{
				
					query.should(QueryBuilders.queryStringQuery(titre)
					.lenient(true)
					.field("titre")
					.fuzziness(Fuzziness.AUTO)
									);
		}
		if(!auteur.isBlank())
		{
			query.should(QueryBuilders.queryStringQuery(auteur)
					.lenient(true)
					.field("auteur")
					.fuzziness(Fuzziness.AUTO)
									);
			}
		if(!contenu.isBlank())
		{
			query.should(QueryBuilders.queryStringQuery(contenu)
					.lenient(true)
					.field("contenu")
					.fuzziness(Fuzziness.AUTO)
									);
			}
		
		NativeSearchQuery qB =new NativeSearchQueryBuilder()
				.withQuery(query)
				.build();
		
		SearchHits<Document> searchHits  =est.search(qB, Document.class);
		
		 return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	
	
	public int[] retrieveId(List<Document> liste)
	{
		Vector ints=new Vector();
		for(int i=0;i<liste.size();i++)		
			ints.add(liste.get(i).getId());

		int [] ret=new int[ints.size()];
		for(int i=0;i<ints.size();i++)
			ret[i]=((Integer)ints.elementAt(i)).intValue();
		
		return ret;
	}

	public int[] getIdListeAdvancedFind(String titre,String auteur,String contenu)
	 {
		List<Document> ld=this.AdvancedFind(titre, auteur, contenu);
			return this.retrieveId(ld);
	 }
	 
}
