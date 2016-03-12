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
	
	@RequestMapping("/")
	public List<Tenant> index() {
		System.out.println("Getting tenant stuff");
		
		return impl.findAll();
	}

	@RequestMapping("/property/{id}")
	public Property findProperty(@PathVariable String id) {
		System.out.println("Looking for property id: " + id);
		return impl.findProperty(id);
	}
	
	@RequestMapping("/property/tenants/{id}")
	public List<Tenant> findTenantsInProperty(@PathVariable String id) {
		System.out.println("Looking for tentants in property id: " + id);
		return impl.findTenantsInProperty(id);
	}
	

	@RequestMapping("/{id}")
    public Tenant findPayment(@PathVariable String id) {
		System.out.println("id was: " + id);
		return impl.findTenantById(id);
    }
	
	@RequestMapping("/setup")
	public void firstTimeSetup() {
		System.out.println("Running first time setup");
		impl.firstTimeSetup();
	}
	
	@RequestMapping("/veridu")
	public void veridu();
		impl.veridu();
	}
	
}
