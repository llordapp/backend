package io.hackathon.llord.tenantvalidator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	
//	public List<Tenant> findAll() {
//		return tenantValidatorReposiory.findAll();
//	}
//	
//	public Tenant findTenantById(String id) {
//		return tenantValidatorReposiory.findTenantByTenantId(id);
//	}
//	
//	public Tenant findProperty(String address) {
//		return propertyRepository.findPropertyByPropertyId(address);
//	}
	
	public List<Tenant> findAllTenants()
	{
		List<Property> properties = propertyRepository.findAll();
		HashMap<String, Tenant> tenants = new HashMap<String, Tenant>();
		for(Property property : properties)
		{
			if (property == null)
				continue;
			
			for(Tenant tenant : property.getTenants())
			{
				if (!tenants.containsKey(tenant.getFirstName() + " " + tenant.getLastName()))
				{
					tenants.put(tenant.getFirstName() + " " + tenant.getLastName(), tenant);
				}
			}
		}
		return (List<Tenant>) tenants.values();
	}
	
	public List<Tenant> findTenantsInProperty(String propertyId) {
		return tenantValidatorReposiory.findTentantsByPropertyId(propertyId);
	}
	
	public List<Property> findAllProperties()
	{
		return propertyRepository.findAll();
	}
	
	public void firstTimeSetup() {
		
		propertyRepository.deleteAll();
		
		Tenant tenant1 = new Tenant("Jaime", "Clinton");
		Tenant tenant2 = new Tenant("James", "Butler");
		Tenant tenant3 = new Tenant("Quynh", "Nhim");
		Tenant tenant4 = new Tenant("Saci", "Sebo");
		
		
		List<Tenant> property1Tenants = new ArrayList<Tenant>(1);
		property1Tenants.add(tenant1);
		List<Tenant> property2Tenants = new ArrayList<Tenant>(1);
		property1Tenants.add(tenant2);
		List<Tenant> property3Tenants = new ArrayList<Tenant>(2);
		property1Tenants.add(tenant3);
		property1Tenants.add(tenant4);
		
		Property property1 = new Property("40 Magic Road, MAG 1CS", 450l, 3, property1Tenants);
		Property property2 = new Property("150 Canning Town, E16 1FC", 475l, 10, property2Tenants);
		Property property3 = new Property("12 Frontside, E12 3FA", 520l, 6, property3Tenants);		
		
		property1 = propertyRepository.save(property1);
		property2 = propertyRepository.save(property2);
		property3 = propertyRepository.save(property3);				
	}
}
