package io.hackathon.llord.tenantvalidator.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.hackathon.llord.dao.domain.Property;
import io.hackathon.llord.dao.domain.Tenant;
import io.hackathon.llord.tenantvalidator.repositories.PropertyRepository;
import io.hackathon.llord.tenantvalidator.repositories.TenantValidatorRepository;

public class TenantValidatorImpl {

	@Autowired
	TenantValidatorRepository tenantValidatorReposiory;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	public List<Tenant> findAll() {
		return tenantValidatorReposiory.findAll();
	}
	
	public Tenant findTenantById(String id) {
		return tenantValidatorReposiory.findTenantById(id);
	}
	
	public Property findProperty(String id) {
		return propertyRepository.findProperty(id);
	}
	
	public List<Tenant> findTenantsInProperty(String propertyId) {
		return tenantValidatorReposiory.findTentants(propertyId);
	}
	
	public void firstTimeSetup() {
		
		
		// TODO:
	}
}
