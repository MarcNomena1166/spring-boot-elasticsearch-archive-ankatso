package com.SpringSecurity.document_a_valider;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="documentAValider")
public class Document_a_validerController {

	Document_a_validerService ds;
	
	@Value("${file.download-dir}")
	String FILE_DIRECTORY;
	
	
	@Autowired
	public Document_a_validerController(Document_a_validerService ds) {
		super();
		this.ds = ds;
	}

	@GetMapping
	public List<Document_a_valider> getDocumentAValider()
	{
		return this.ds.getDocumentAValider();
	}
	
	@PostMapping(path="/{id}")
	public void validerDocument(@PathVariable("id")String id)
	{
		this.ds.validerDoc(id);
	}
	
	@PutMapping
	public void commenterDocument(@RequestParam("id")String id,@RequestParam("commentaire")String commentaire)
	{
		this.ds.commenterDoc(id, commentaire);
	}
	
	@GetMapping(path="/{filename}")
	public void downloadDocument(@PathVariable("filename")String name,HttpServletResponse response)
	{
		String filename=FILE_DIRECTORY+"\\"+name;
		try {
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis= new FileInputStream(filename);
			int len;
			byte[] buf=new byte[1024];
			
			while((len=fis.read(buf))>0)
			{
				bos.write(buf,0, len);
			}
			bos.close();
			response.flushBuffer();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
