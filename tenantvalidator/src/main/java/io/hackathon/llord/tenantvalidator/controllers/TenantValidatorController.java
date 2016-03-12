package io.hackathon.llord.tenantvalidator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.llord.dao.domain.Property;
import io.hackathon.llord.dao.domain.Tenant;
import io.hackathon.llord.tenantvalidator.impl.TenantValidatorImpl;

@RestController
public class TenantValidatorController {

	@Autowired
	TenantValidatorImpl impl;

	@RequestMapping("/property/tenants")
	public List<Tenant> findAllTenants() {
		System.out.println("Finding all tenants");
		return impl.findAllTenants();
	}

	// distinct addresses
	// list of tenants
	@RequestMapping("/property")
	public List<Property> findAllProperties() {
		System.out.println("Finding all properties");
		return impl.findAllProperties();
	}

	@RequestMapping("/setup")
	public void firstTimeSetup() {
		System.out.println("Running first time setup");
		impl.firstTimeSetup();
	}

	@RequestMapping("/veridu")
	public void veridu() {
		impl.veridu();
	}
}
