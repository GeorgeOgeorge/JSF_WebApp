package Util;

import javax.faces.context.FacesContext;

import org.junit.Test;

public class JPAUtilTest {
	@Test
	public void getEntityManager() {
		String implementationVersion = FacesContext.class.getPackage().getImplementationVersion();
		System.out.println(implementationVersion);
	}
	
}
