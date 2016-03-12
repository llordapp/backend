package io.hackathon.llord.paymentrequests.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration
{ 
    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception 
    {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() 
    {
        return "MyDB";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception 
    {
        return new MongoClient("25.105.222.31" , 13337 );
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception 
    {
        return new MongoTemplate(mongo(), getDatabaseName());
    }    
}
