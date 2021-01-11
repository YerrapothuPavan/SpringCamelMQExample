package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyTransformProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String inputBody=exchange.getIn().getBody(String.class);
		System.out.println("input body = "+inputBody);
	}

}
