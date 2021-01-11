package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component("FTPPollingRoute")
public class FTPPollingRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		/*from("direct:FTPComponent")
		.log("File component invloked")
		.from("file://C://Users//863018//Projects//Training//CamelMQTest//sample.txt")
		.convertBodyTo(String.class)
		.log("Reading from a file")
		.setHeader("Interfacename", simple("us84"))
		.log("${header.Interfacename}")
		.log("body = ${body}")
		.end();*/
		
	}
		
		
		

}
