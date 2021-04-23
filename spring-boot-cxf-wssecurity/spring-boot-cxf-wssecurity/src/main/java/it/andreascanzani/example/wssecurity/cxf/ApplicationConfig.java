package it.andreascanzani.example.wssecurity.cxf;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.andreascanzani.example.wssecurity.cxf.impl.SumServiceImpl;

@Configuration
public class ApplicationConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint(SumServiceImpl sumServiceImpl) {
		EndpointImpl endpoint = new EndpointImpl(bus, sumServiceImpl, javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING);
		// http://localhost:8080/services/soap/SumService?wsdl
		endpoint.publish("/soap/SumService");
		return endpoint;
	}
	
}