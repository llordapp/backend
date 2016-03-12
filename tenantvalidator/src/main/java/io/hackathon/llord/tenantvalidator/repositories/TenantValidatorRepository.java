package io.hackathon.llord.tenantvalidator.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.hackathon.llord.dao.domain.Tenant;

@Repository
public interface TenantValidatorRepository extends MongoRepository<Tenant, String> {
	public Tenant findTenantById(String tenantId);
	public List<Tenant> findAll();
	public List<Tenant> findTentants(String propertyId);
}
