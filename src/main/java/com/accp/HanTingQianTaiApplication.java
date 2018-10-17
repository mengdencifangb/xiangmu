package com.accp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HanTingQianTaiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HanTingQianTaiApplication.class, args);
	}
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {//war
		return builder.sources(HanTingQianTaiApplication.class);
	}
}
