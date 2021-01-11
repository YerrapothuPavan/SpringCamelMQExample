package com.example.demo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.hibernate.validator.internal.util.privilegedactions.Unmarshal;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.Product;

//@Component
public class SimpleCamelRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		DataFormat bindy = new BindyCsvDataFormat(Product.class);		
		
		/*from("file://C:\\Users\\863018\\Projects\\Training\\CamelTraining\\In?delete=true")
			.log("moving file from in location")
			.to("file://C:\\Users\\863018\\Projects\\Training\\CamelTraining\\Out");*/
		
		//Timer example
		//from("timer:hello?period=10s")
		from("timer:hello?period=10s")
			.log("moving files using timer component")
			.pollEnrich("file://C:\\Users\\863018\\Projects\\Training\\CamelTraining\\In?delete=true")
			.to("file://C:\\Users\\863018\\Projects\\Training\\CamelTraining\\Out")
			.unmarshal(bindy)
			.log("unmarshal object : ${body}")
				.split(body())
				.log("split record is : ${body}")
				.end();
			
		
	}

}
