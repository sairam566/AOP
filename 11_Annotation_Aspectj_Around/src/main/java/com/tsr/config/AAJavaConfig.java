package com.tsr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tsr.helper.Cache;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.tsr.beans", "com.tsr.aspect" })
public class AAJavaConfig {

	@Bean
	public Cache instantiate() {
		return Cache.getInstance();
	}
}
