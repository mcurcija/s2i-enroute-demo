package com.example.enroute.demo.application;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;

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

	public String getUpper(String string) {
		return string.toUpperCase();
	}

	public String getRandom() throws UnknownHostException {
		return UUID.randomUUID().toString() + ":" + InetAddress.getLocalHost().getHostName();
	}
}
