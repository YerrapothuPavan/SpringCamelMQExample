package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component("TimerComponent")
public class TimerComponent extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		/*from("timer://polltest?fixedRate=true&period=6s")
		.log("Time component invloked")
		.to("direct:FTPComponent");
		*/
		
	}

}
