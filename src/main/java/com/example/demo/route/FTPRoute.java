package com.example.demo.route;

import javax.sql.DataSource;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.exception.DataException;
import com.example.demo.pojo.MyProduct;
import com.example.demo.pojo.Product;
import com.example.demo.processor.MySQLProcessor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

//@Component
public class FTPRoute extends RouteBuilder{
	
	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MySQLProcessor mySQLProcessor;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		DataFormat bindy = new BindyCsvDataFormat(MyProduct.class);
		
		//errorHandler(deadLetterChannel("log:errorOccuredInRoute?level=ERROR&showProperties=true"));
		/*.maximumRedeliveries(2).redeliveryDelay(3000).
				backOffMultiplier(2));*/
		
		onException(MySQLSyntaxErrorException.class).log(LoggingLevel.ERROR,"SQL Exception in Route ${body}");
		//.maximumRedeliveries(2).redeliveryDelay(2000);
		
		onException(DataException.class).log(LoggingLevel.ERROR,"Data Exception in Route ${body}");
		
		
		from("{{startRoute}}")
			.log("from time component")
			.pollEnrich("{{fromRoute}}")
			.to("{{toRoute}}")
			.unmarshal(bindy)
			.log("unmarshalled object :${body}")
			.split(body())
			.log("After spilitting : ${body}")
			//.marshal().json(JsonLibrary.Jackson, true)
			.log("after marshhalling : ${body}")
			//.process(new MySQLProcessor())
			//.to("jdbc:dataSource")
			.end();
		
		
	}

}
