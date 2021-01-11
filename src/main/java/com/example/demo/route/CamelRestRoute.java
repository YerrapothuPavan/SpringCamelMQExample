package com.example.demo.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRestRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("{{startRoute}}")
			.log("from rest timer component")
			.to("https://restcountries.eu/rest/v2/alpha/IN")
			.log("Rest Response : ${body}")
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.to("http://localhost:8081/country");
	}

}
