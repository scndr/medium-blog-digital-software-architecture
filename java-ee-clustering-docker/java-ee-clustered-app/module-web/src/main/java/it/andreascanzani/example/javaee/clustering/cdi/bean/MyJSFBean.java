package it.andreascanzani.example.javaee.clustering.cdi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import it.andreascanzani.example.javaee.clustering.ejb.EJBStateful;
import it.andreascanzani.example.javaee.clustering.ejb.EJBStateless;

@Named
@SessionScoped
public class MyJSFBean implements Serializable {
	private static final long serialVersionUID = 6747115373025350156L;

	private String attribute;
	private String value;
	private List<String> listAttribute = new ArrayList<String>();

	@EJB
	EJBStateless ejbStateless;
	@EJB
	EJBStateful ejbStateful;

	public String submit() {
		System.out.println(attribute + "=" + value);
		listAttribute.add(attribute + "=" + value);
		ejbStateful.increment();
		return null;
	}

	public String refresh() {
		return null;
	}

	public String getUuid() {
		return ejbStateless.getUUID();
	}

	public int getCount() {
		return ejbStateful.getCount();
	}
	
	public String getSessionId() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		return session.getId();
	}

	public String getJbossNodeName() {
		return System.getProperty("jboss.node.name");
	}

	public String getJbossHostName() {
		return System.getProperty("jboss.host.name");
	}

	public List<String> getListAttribute() {
		return listAttribute;
	}

	public void setListAttribute(List<String> listAttribute) {
		this.listAttribute = listAttribute;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
