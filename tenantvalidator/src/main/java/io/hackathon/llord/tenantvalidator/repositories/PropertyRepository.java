package io.hackathon.llord.tenantvalidator.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.hackathon.llord.dao.domain.Property;

@Repository
public interface PropertyRepository  extends MongoRepository<Property, String> {

	public List<Property> findAll();
	public Property findPropertyByPropertyId(String propertyId);
}
