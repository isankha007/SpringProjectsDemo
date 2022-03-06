package com.sankha.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
//	@Autowired
//	private Environment environment;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrecnyConversion calculateCurrencyCOnversion(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String,String> uriVariables=new HashMap();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		ResponseEntity<CurrecnyConversion> responseEntity = new RestTemplate().getForEntity
		("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrecnyConversion.class,uriVariables);
		CurrecnyConversion currecnyConversion = responseEntity.getBody();
		//String port =environment.getProperty("local.server.port");
		BigDecimal conversionMultiple = currecnyConversion.getConversionMultiple();
		return new CurrecnyConversion(currecnyConversion.getId(), from, to, quantity,conversionMultiple,
				quantity.multiply(conversionMultiple), currecnyConversion.getEnvironment()+" "+"Rest template");
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrecnyConversion calculateCurrencyCOnversionFeign(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrecnyConversion currecnyConversion = proxy.retriveValue(from, to);
		//String port =environment.getProperty("local.server.port");
		BigDecimal conversionMultiple = currecnyConversion.getConversionMultiple();
		return new CurrecnyConversion(currecnyConversion.getId(), from, to, quantity,conversionMultiple,
				quantity.multiply(conversionMultiple), currecnyConversion.getEnvironment()+" "+"Feign");
		
	}
}
