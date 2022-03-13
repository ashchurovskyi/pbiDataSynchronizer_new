package com.barcom.pbiDataSynchronizer;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ch.qos.logback.classic.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PbiDataSynchronizerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PbiDataSynchronizerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PbiDataSynchronizerApplication.class, args);
	}



}
