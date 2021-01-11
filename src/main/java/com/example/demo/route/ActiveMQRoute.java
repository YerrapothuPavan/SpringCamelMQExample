package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.JSONProduct;

//@Component
public class ActiveMQRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		GsonDataFormat productFormat = new GsonDataFormat(JSONProduct.class);
		
		from("activemq:{{activemq.queuename}}")
			.routeId("sampleActiveMQ")
			.log("input message from queue: ${body}")
			.unmarshal(productFormat)
			.log("after unmarshalling: ${body})")
			.convertBodyTo(String.class)
			.to("activemq:{{activemq.outqueuename}}");
			
	}

}
