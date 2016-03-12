package io.hackathon.llord.tenantvalidator;

import io.hackathon.llord.tenantvalidator.impl.TenantValidatorImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TenantValidatorMain 
{
	@Bean
	TenantValidatorImpl tenantValidatorImpl()
	{
		return new TenantValidatorImpl();
	}
	
    public static void main( String[] args )
    {
		SpringApplication.run(TenantValidatorMain.class, args);
    }
}
