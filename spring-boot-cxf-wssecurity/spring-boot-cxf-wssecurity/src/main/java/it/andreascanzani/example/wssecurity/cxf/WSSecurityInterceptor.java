package it.andreascanzani.example.wssecurity.cxf;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.stereotype.Component;

@Component
public class WSSecurityInterceptor extends WSS4JInInterceptor {
	
	static Map<String, Object> wsSecurityInterceptorConfig;
	static {
		wsSecurityInterceptorConfig = new HashMap<String, Object>();
		wsSecurityInterceptorConfig.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		wsSecurityInterceptorConfig.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		wsSecurityInterceptorConfig.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernameTokenCallbackHandler.class.getName());
	}

	public WSSecurityInterceptor() {
		super(wsSecurityInterceptorConfig);
	}

}
