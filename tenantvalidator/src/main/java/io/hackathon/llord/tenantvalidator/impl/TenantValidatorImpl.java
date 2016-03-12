package io.hackathon.llord.tenantvalidator.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.veridu.sdk.Request;
import com.veridu.sdk.Session;
import com.veridu.sdk.UserDetails;

import io.hackathon.llord.dao.domain.Property;
import io.hackathon.llord.dao.domain.Tenant;
import io.hackathon.llord.tenantvalidator.Settings;
import io.hackathon.llord.tenantvalidator.repositories.PropertyRepository;

public class TenantValidatorImpl {
	
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
		return new ArrayList<Tenant>(tenants.values());
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
		property2Tenants.add(tenant2);
		List<Tenant> property3Tenants = new ArrayList<Tenant>(2);
		property3Tenants.add(tenant3);
		property3Tenants.add(tenant4);
		
		Property property1 = new Property("40 Magic Road, MAG 1CS", 450l, 3, property1Tenants);
		Property property2 = new Property("150 Canning Town, E16 1FC", 475l, 10, property2Tenants);
		Property property3 = new Property("12 Frontside, E12 3FA", 520l, 6, property3Tenants);		
		
		property1 = propertyRepository.save(property1);
		property2 = propertyRepository.save(property2);
		property3 = propertyRepository.save(property3);				
	}
	
	public void veridu() {
		Request veriduRequest = new Request(Settings.CLIENT, Settings.SECRET);
        veriduRequest.setVersion("0.3");
        Session veriduSession = new Session(veriduRequest);
        if (!veriduSession.Create(false)) {
            System.err.println("Failed to create session!");
            System.err.printf("Error: %s\n", veriduSession.lastError());
            return;
        }
        if (!veriduSession.Assign("gw_56e3c4eb2bf44767512946")) {
            System.err.println("Failed to create/assign user!");
            System.err.printf("Error: %s\n", veriduSession.lastError());
            return;
        }
        if (!veriduSession.Extend()) {
            System.err.println("Failed to extend session!");
            System.err.printf("Error: %s\n", veriduSession.lastError());
            return;
        }
        JSONObject userData = veriduRequest.fetchResource("GET", "/user/gw_56e3c4eb2bf44767512946/", null);
        if (userData.isEmpty()) {
            System.err.println("Error: /user/gw_56e3c4eb2bf44767512946 returned an empty response!");
        } else {
            System.out.println(userData.toJSONString());
        }
        JSONObject userProviders = veriduRequest.fetchResource("GET", "/provider/gw_56e3c4eb2bf44767512946/", null);
        if (userProviders.isEmpty()) {
            System.err.println("Error: /provider/gw_56e3c4eb2bf44767512946 returned an empty response!");
        } else {
            System.out.println(userProviders.toJSONString());
        }
        JSONObject userKBA = veriduRequest.fetchResource("GET", "/kba/gw_56e3c4eb2bf44767512946/", null);
        if (userKBA.isEmpty()) {
            System.err.println("Error: /kba/gw_56e3c4eb2bf44767512946 returned an empty response!");
        } else {
            System.out.println(userKBA.toJSONString());
        }
        
        JSONObject userDetails = veriduRequest.fetchResource("GET", "/details/gw_56e3c4eb2bf44767512946/", null);
        UserDetails details = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
        	details = mapper.readValue(userDetails.toString(), UserDetails.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (details != null) {
        	System.out.println("hooray");
        }
        
        if (userDetails.isEmpty()) {
            System.err.println("Error: /kba/gw_56e3c4eb2bf44767512946 returned an empty response!");
        } else {
            System.out.println(userDetails.toJSONString());
        }
        
        
        JSONObject userOTP = veriduRequest.fetchResource("GET", "/otp/gw_56e3c4eb2bf44767512946/", null);
        if (userOTP.isEmpty()) {
            System.err.println("Error: /otp/gw_56e3c4eb2bf44767512946 returned an empty response!");
        } else {
            System.out.println(userOTP.toJSONString());
        }
        if (!veriduSession.Expire()) {
            System.err.println("Failed to expire session!");
            System.err.printf("Error: %s\n", veriduSession.lastError());
        }
	}
}
