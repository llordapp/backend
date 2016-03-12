package io.hackathon.llord.tenantvalidator.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.hackathon.llord.dao.domain.Property;

public interface PropertyRepository  extends MongoRepository<Property, String> {

	public List<Property> findAll();
	public Property findProperty(String propertyId);
}
