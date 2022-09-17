package com.SpringSecurity.ESConfiguration;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="com.SpringSecurity.ESRepository")
@ComponentScan(basePackages= {"com.SpringSecurity"})
public class Config extends AbstractElasticsearchConfiguration{
	
	String elasticsearchURL="localhost:9200";
	
	

	
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration config= ClientConfiguration.builder()
				.connectedTo(elasticsearchURL)
				.build();
		// TODO Auto-generated method stub
		return RestClients.create(config).rest();
	}
	

}
