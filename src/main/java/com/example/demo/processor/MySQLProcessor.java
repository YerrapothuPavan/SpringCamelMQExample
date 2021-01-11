package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.demo.exception.DataException;
import com.example.demo.pojo.MyProduct;

@Component
public class MySQLProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		
	MyProduct product = (MyProduct)	exchange.getIn().getBody();
	
	StringBuilder query = new StringBuilder();
	
	if(ObjectUtils.isEmpty(product.getProductId())){
		throw new DataException("product id is null for "+product.getDescription());
	}
	
	query.append("INSERT INTO PRODUCTS1 (PRODUCTID,DESCRIPTION,BRAND,PRICE) VALUES ('");
	query.append(product.getProductId()+"','"+product.getDescription()+"','"+product.getBrand()+"',"+product.getPrice()+")");
	
	System.out.println("Query is : "+query);
		
	exchange.getIn().setBody(query.toString());

	}

}
