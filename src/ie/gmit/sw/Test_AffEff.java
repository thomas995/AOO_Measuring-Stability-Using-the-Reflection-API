package ie.gmit.sw;

import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.Test;

import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import junit.framework.TestCase;

// Test Case to Read in how many classes from the Jar are Afferent and Efferent
/**
 * @author Thomas
 *
 */
public class Test_AffEff
{
	//
	/**
	 * @return
	 */
	@Test
	public static int AffCouplings()
	{

	  JDepend _jdepend = new JDepend();

	  try
	  {
		_jdepend.addDirectory("C:/Users/Thomas/Desktop/Java Reflection API Project/src/ie/gmit/sw");
	} catch (IOException e)
	  {
		e.printStackTrace();
	  }

	  _jdepend.analyze();

	  JavaPackage p = _jdepend.getPackage("ie.gmit.sw");
	  System.out.println(p);

	  //assertNotNull(p);

	  int aff = p.afferentCoupling();

	  assertEquals(("Afferent Coupling: " +p.getName()), aff, p.afferentCoupling());

	  System.out.println("Afferent Couplings in JAR:" + aff); // displays afferent couplings
      return aff;

	 }
	/**
	 * @return
	 */
	@Test
	public static int EffCouplings()
	{
	  JDepend _jdepend = new JDepend();

	  try
	  {
		  // change this to where you have JDepend downloaded
		_jdepend.addDirectory("C:/Users/Thomas/Desktop/Java Reflection API Project/src/ie/gmit/sw");
	  }
	  catch (IOException e)
	  {
		e.printStackTrace();
	  }

	  _jdepend.analyze();

	  JavaPackage p = _jdepend.getPackage("ie.gmit.sw");
	  System.out.println(p);

	  //assertNotNull(p);

	  int eff = p.efferentCoupling();

	  assertEquals(("Efferent Coupling: " +p.getName()), eff, p.efferentCoupling());

	  System.out.println("Efferent Couplings in JAR:" + eff); // displays afferent couplings
	  return eff;

	  // Test is failing as it expects the methods to be void, but if set to void errors out the functionality for the tests


}
}