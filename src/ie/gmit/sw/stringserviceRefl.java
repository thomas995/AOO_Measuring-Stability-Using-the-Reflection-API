package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author Thomas
 *
 */
public class stringserviceRefl
{
	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{

		// Info from JAR file
		 System.out.println("JAR CONTENTS:");
		JarInputStream in = new JarInputStream(new FileInputStream(new File("C:/Users/Thomas/Desktop/Java Reflection API Project/string-service.jar")));
		JarEntry next = in.getNextJarEntry();
		while (next != null)
		{
		 if (next.getName().endsWith(".class"))
		 {
		 String name = next.getName().replaceAll("/", "\\.");
		 name = name.replaceAll(".class", "");
		 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
		 System.out.println(name);
		 }
		 next = in.getNextJarEntry();
		}
		System.out.println();

	     // Class to be reflected
		Class reflectClass = Class.forName("ie.gmit.sw.stringservice");

	     // Getting the class name being reflected
	     String className = reflectClass.getName();
	     System.out.println("Class Name:");
	     System.out.println(className + "\n");

	     // Getting the package name being reflected
	     Package pack = reflectClass.getPackage();
	     System.out.println("Package Name:");
	     System.out.println(pack + "\n");

	     // Get the field name being reflected
	     Field[] fields = reflectClass.getFields();
	     System.out.println("Field Name:");
	     System.out.println(fields + "\n");

	     // Get the super class for the current class being read in
	     Class Super = reflectClass.getSuperclass();
	     System.out.println("Superclass name:");
	     System.out.println(Super.getName() + "\n");

	     //Any Public Classes
	     int publicClass = reflectClass.getModifiers();
	     System.out.println("Public Classes:");
	     System.out.println(Modifier.isPublic(publicClass) + "\n");

	     //Any Private Classes
	     int privateClass = reflectClass.getModifiers();
	     System.out.println("Private Classes:");
	     System.out.println(Modifier.isPrivate(privateClass) + "\n");

	   //Any Abstract classes
	     int AbstractClass = reflectClass.getModifiers();
	     System.out.println("Abstract Classes:");
	     System.out.println(Modifier.isAbstract(AbstractClass) + "\n");

	     //Any Final Classes
	     int finalClass = reflectClass.getModifiers();
	     System.out.println("Final Classes:");
	     System.out.println(Modifier.isFinal(finalClass) + "\n");

	     //Any Interface Classes
	     int interfaceClass = reflectClass.getModifiers();
	     System.out.println("Interface Classes:");
	     System.out.println(Modifier.isInterface(interfaceClass) + "\n");


	     //getting the methods of the class
	     Method[] Methods = reflectClass.getMethods();

	     // for loop for outputting whether or not getters and setters are within the class
	     for(Method myMethod : Methods){

	         // stringservice Methods
	         System.out.println("Method Name: " + myMethod.getName());

	         // check stringservice for getter
	         if(myMethod.getName().startsWith("get"))
	         {
	             System.out.println("Getter?");
	         }
	         // check stringservice for setter
	         else if(myMethod.getName().startsWith("set"))
	         {
	             System.out.println("Setter");
	         }

	         //Getting Return Types
	         System.out.println("Return Type: " + myMethod.getReturnType());

	         Class[] parameterType = myMethod.getParameterTypes();

	         // Parameters of the class
	         System.out.println("Parameters:");

	         for(Class parameter : parameterType)
	         {
	             System.out.println(parameter.getName());
	         }
	         System.out.println();
	     }

	     // Constructors
	     Constructor constructor = null;
	     Object constructor2 = null;

         //returns constructors found
	     System.out.println("Constructors:");
         Constructor[] constructors = reflectClass.getConstructors();
         stringserviceRefl Ref = new stringserviceRefl();
         return;

	}
	// Copy of the above code, used as a reference for the AppWindow to display to the console
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void ReflRefStringService() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		// Info from JAR file
				 System.out.println("JAR CONTENTS:");
				JarInputStream in = new JarInputStream(new FileInputStream(new File("C:/Users/Thomas/Desktop/Java Reflection API Project/string-service.jar")));
				JarEntry next = in.getNextJarEntry();
				while (next != null)
				{
				 if (next.getName().endsWith(".class"))
				 {
				 String name = next.getName().replaceAll("/", "\\.");
				 name = name.replaceAll(".class", "");
				 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
				 System.out.println(name);
				 }
				 next = in.getNextJarEntry();
				}
				System.out.println();

			     // Class to be reflected
				Class reflectClass = Class.forName("ie.gmit.sw.stringservice");

			     // Getting the class name being reflected
			     String className = reflectClass.getName();
			     System.out.println("Class Name:");
			     System.out.println(className + "\n");

			     // Getting the package name being reflected
			     Package pack = reflectClass.getPackage();
			     System.out.println("Package Name:");
			     System.out.println(pack + "\n");

			     // Get the field name being reflected
			     Field[] fields = reflectClass.getFields();
			     System.out.println("Field Name:");
			     System.out.println(fields + "\n");

			     // Get the super class for the current class being read in
			    // Class Super = reflectClass.getSuperclass();
			    // System.out.println("Superclass name:");
			    // System.out.println(Super.getName() + "\n");

			     //Any Public Classes
			     int publicClass = reflectClass.getModifiers();
			     System.out.println("Public Classes:");
			     System.out.println(Modifier.isPublic(publicClass) + "\n");

			     //Any Private Classes
			     int privateClass = reflectClass.getModifiers();
			     System.out.println("Private Classes:");
			     System.out.println(Modifier.isPrivate(privateClass) + "\n");

			   //Any Abstract classes
			     int AbstractClass = reflectClass.getModifiers();
			     System.out.println("Abstract Classes:");
			     System.out.println(Modifier.isAbstract(AbstractClass) + "\n");

			     //Any Final Classes
			     int finalClass = reflectClass.getModifiers();
			     System.out.println("Final Classes:");
			     System.out.println(Modifier.isFinal(finalClass) + "\n");

			     //Any Interface Classes
			     int interfaceClass = reflectClass.getModifiers();
			     System.out.println("Interface Classes:");
			     System.out.println(Modifier.isInterface(interfaceClass) + "\n");


			     //getting the methods of the class
			     Method[] Methods = reflectClass.getMethods();

			     // for loop for outputting whether or not getters and setters are within the class
			     for(Method myMethod : Methods){

			         // stringservice Methods
			         System.out.println("Method Name: " + myMethod.getName());

			         // check stringservice for getter
			         if(myMethod.getName().startsWith("get"))
			         {
			             System.out.println("Getter?");
			         }
			         // check stringservice for setter
			         else if(myMethod.getName().startsWith("set"))
			         {
			             System.out.println("Setter");
			         }

			         //Getting Return Types
			         System.out.println("Return Type: " + myMethod.getReturnType());

			         Class[] parameterType = myMethod.getParameterTypes();

			         // Parameters of the class
			         System.out.println("Parameters:");

			         for(Class parameter : parameterType)
			         {
			             System.out.println(parameter.getName());
			         }
			         System.out.println();
			     }

			     // Constructors
			     Constructor constructor = null;
			     Object constructor2 = null;

		         //returns constructors found
			     System.out.println("Constructors:");
		         Constructor[] constructors = reflectClass.getConstructors();
		         stringserviceRefl Ref = new stringserviceRefl();
		         System.out.println("------------------------------------------------ ");
		         return;
	}
}
