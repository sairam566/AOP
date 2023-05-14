package com.tsr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tsr.helper.AuthenticationManager;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.tsr.beans", "com.tsr.aspect" })
public class ABJavaConfig {

	@Bean
	public AuthenticationManager authenticationManager() {
		return AuthenticationManager.getInstance();
	}
}
