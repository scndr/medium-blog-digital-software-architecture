package it.andreascanzani.example.javaee.clustering.rest;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.andreascanzani.example.javaee.clustering.ejb.EJBStateless;

@ApplicationPath("api")
@Path("/uuid")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class RestApi {

	@EJB
	EJBStateless ejbStateless;

	@GET
	public BeanResponseRest getUUID() {
		BeanResponseRest toReturn = new BeanResponseRest();
		toReturn.setNodeName(System.getProperty("jboss.node.name"));
		toReturn.setUuid(ejbStateless.getUUID());
		return toReturn;
	}
	
}
