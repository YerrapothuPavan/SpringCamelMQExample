package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.MyProduct;

//@Component
public class FTPDBRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		DataFormat bindy = new BindyCsvDataFormat(MyProduct.class);
		
		from("{{startRoute}}")
			.log("from time component")
			.log("{{message}}")
			.pollEnrich("{{fromRoute}}")
			.to("{{toRoute}}")
			.unmarshal(bindy)
			.log("unmarshalled object :${body}")
			.split(body())
			.log("After spilitting : ${body}");
		
		
	}

}
