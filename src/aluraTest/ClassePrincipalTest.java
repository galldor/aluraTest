package aluraTest;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ClassePrincipalTest extends TestCase {
	@Test
	public void testPositive() {
		String stringPositiveTest1 = ClassePrincipal.limpa("1-­800-­ALURA");
	    Assert.assertEquals(stringPositiveTest1, "180025872");
	     
	    String stringPositiveTest2 = ClassePrincipal.limpa("1­-800-­25872");
	    Assert.assertEquals(stringPositiveTest2, "180025872");
	    
	    String stringPositiveTest3 =ClassePrincipal.limpa("55CAELUM");
	    Assert.assertEquals(stringPositiveTest3, "55223586");
	}
	
	public void testNegative() {
		String stringNegativeTest1 = ClassePrincipal.limpa("[[)('/]''/.,;[");
	    Assert.assertEquals(stringNegativeTest1, "");
	    
	    String stringNegativeTest2 = ClassePrincipal.limpa("");
	    Assert.assertEquals(stringNegativeTest2, "");
	}
}
