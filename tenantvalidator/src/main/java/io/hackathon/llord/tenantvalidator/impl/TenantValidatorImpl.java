package io.hackathon.llord.tenantvalidator.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.veridu.gateway.exception.TokenVerificationFailed;
import com.veridu.gateway.sdk.Callback;
import com.veridu.gateway.sdk.Redirect;

import io.hackathon.llord.dao.domain.Property;
import io.hackathon.llord.dao.domain.Tenant;
import io.hackathon.llord.tenantvalidator.Settings;
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
	
	public void veridu() {
		try {
			Redirect redir = new Redirect(Settings.CLIENT, Settings.SECRET);
            // Unique username assigned by your system (this is an optional parameter for redir.generateUrl)
            // more info: https://veridu.com/wiki/User_ID
            String username = "unique-user-id";

            // generate redirect url with appended signature (username parameter is optional)
            System.out.println("URL: ".concat(redir.generateUrl(username)));
            // redirect token id for callback validation
            System.out.println("TID: ".concat(redir.getTokenId()));
        } catch (UnsupportedEncodingException | JoseException ex) {
           	ex.printStackTrace();
        }
	}
}
