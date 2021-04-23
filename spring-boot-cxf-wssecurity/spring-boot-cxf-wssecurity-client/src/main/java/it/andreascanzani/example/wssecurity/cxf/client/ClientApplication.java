package it.andreascanzani.example.wssecurity.cxf.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.andreascanzani.sumservice.schema.GetSumRequest;
import it.andreascanzani.sumservice.wsdl.SumService;
import it.andreascanzani.sumservice.wsdl.SumServicePort;

@SpringBootApplication
@EnableAutoConfiguration
public class ClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	public void run(String... args) throws Exception {
		SumService sumService = new SumService();
		SumServicePort sumServiceSOAPBinding = sumService.getSumServiceSOAPBinding();

		Client client = ClientProxy.getClient(sumServiceSOAPBinding);
		Endpoint endpoint = client.getEndpoint();

		client.getRequestContext().put(Message.ENDPOINT_ADDRESS, "http://localhost:8080/services/soap/SumService");
		
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernameTokenClientCallbackHandler.class.getName());
		props.put(WSHandlerConstants.USER, "admin");

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wssOut);
	
		GetSumRequest parameters = new GetSumRequest();
		parameters.setAddendOne(1);
		parameters.setAddendTwo(3);
		System.out.println(sumServiceSOAPBinding.getSum(parameters).getResult());
	}

}
