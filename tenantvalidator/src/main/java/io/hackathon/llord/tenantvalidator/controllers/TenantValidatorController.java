package io.hackathon.llord.tenantvalidator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.llord.dao.domain.Property;
import io.hackathon.llord.dao.domain.Tenant;
import io.hackathon.llord.tenantvalidator.impl.TenantValidatorImpl;

@RestController
public class TenantValidatorController {

	@Autowired
	TenantValidatorImpl impl;
	
//	@RequestMapping("/")
//	public List<Tenant> index() {
//		System.out.println("Getting tenant stuff");
//		
//		return impl.findAll();
//	}
//
//	@RequestMapping("/property/{id}")
//	public Tenant findProperty(@PathVariable String address) {
//		System.out.println("Looking for property id: " + address);
//		return impl.findProperty(address);
//	}
	
	@RequestMapping("/property/tenants/")
	public List<Tenant> findAllTenants() {
		System.out.println("Finding all tenants");
		return impl.findAllTenants();
	}	

	//distinct addresses
	//list of tenants
	@RequestMapping("/property/")
	public List<Property> findAllProperties()
	{
		System.out.println("Finding all properties");
		return impl.findAllProperties();
	}
	
	@RequestMapping("/setup")
	public void firstTimeSetup() {
		System.out.println("Running first time setup");
		impl.firstTimeSetup();
	}
	
}
