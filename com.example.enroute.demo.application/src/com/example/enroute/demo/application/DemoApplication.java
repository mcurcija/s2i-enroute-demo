package com.example.enroute.demo.application;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import osgi.enroute.configurer.api.RequireConfigurerExtender;
import osgi.enroute.google.angular.capabilities.RequireAngularWebResource;
import osgi.enroute.rest.api.REST;
import osgi.enroute.twitter.bootstrap.capabilities.RequireBootstrapWebResource;
import osgi.enroute.webserver.capabilities.RequireWebServerExtender;

@RequireAngularWebResource(resource = { "angular.js", "angular-resource.js", "angular-route.js" }, priority = 1000)
@RequireBootstrapWebResource(resource = "css/bootstrap.css")
@RequireWebServerExtender
@RequireConfigurerExtender
@Component(name = "com.example.enroute.demo")
public class DemoApplication implements REST {

	static Logger logger = LoggerFactory.getLogger(DemoApplication.class); 
	
	public String getUpper(String string) {
		return string.toUpperCase();
	}

	public RandomDTO getRandom() throws UnknownHostException {
		final RandomDTO result = new RandomDTO();
		result.created = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
		result.uuid = UUID.randomUUID().toString();
		result.hostname = InetAddress.getLocalHost().getHostName();
		logger.info("Generated result: {}", result);
		return result;
	}
}
