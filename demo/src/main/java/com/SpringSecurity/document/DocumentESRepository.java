package com.SpringSecurity.document;

import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DocumentESRepository extends ElasticsearchRepository<Document,Integer>{

}
