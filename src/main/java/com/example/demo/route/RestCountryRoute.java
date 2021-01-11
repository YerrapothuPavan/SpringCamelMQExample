package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class RestCountryRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("In rest country route");
		from("restlet:http://localhost:8081/country?restletMethods=POST")
			.log("Rest country Route body is : ${body}");
	}

}
