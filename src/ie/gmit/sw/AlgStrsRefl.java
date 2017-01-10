package ie.gmit.sw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AlgStrsRefl
{
	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *
	 */
	// reflection class for AlgStrs, which is the same for every class ending in "Refl"
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		// Info from JAR file
		 System.out.println("JAR CONTENTS:"); // outputs title to console which has the classes in the JAR below it

		 // NEED TO CHANGE TO WHERE JAR IS LOCATED ON YOUR MACHINE
		JarInputStream in = new JarInputStream(new FileInputStream(new File("C:/Users/Thomas/Desktop/Java Reflection API Project/string-service.jar")));
		JarEntry next = in.getNextJarEntry();

		// while files are found, remove their extensions before displaying them to the console
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
		Class reflectClass = Class.forName("ie.gmit.sw.AlgStrs");

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
	     for(Method newMethod : Methods){

	         // AlgStrs Methods
	         System.out.println("Method Name: " + newMethod.getName());

	         // check AlgStrs for getter
	         if(newMethod.getName().startsWith("get"))
	         {
	             System.out.println("Getter?");
	         }
	         // check AlgStrs for setter
	         else if(newMethod.getName().startsWith("set"))
	         {
	             System.out.println("Setter");
	         }

	         //Getting Return Types
	         System.out.println("Return Type: " + newMethod.getReturnType());

	         Class[] parameterType = newMethod.getParameterTypes();

	         // Parameters of the class
	         System.out.println("Parameters:");

	         for(Class parameter : parameterType)
	         {
	             System.out.println(parameter.getName());
	         }
	         System.out.println();
	     }

	     // Any Constructors
	     Constructor constructor = null;
	     Object constructor2 = null;

         //returns constructors found
	     System.out.println("Constructors:");
	     System.out.println(constructor);
         Constructor[] constructors = reflectClass.getConstructors();
         AlgStrsRefl Ref = new AlgStrsRefl();
         return;

	}
	/**
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *
	 */
	// Copy of the above code, used as a reference for the AppWindow to display to the console
	public static void ReflRefAlgStrs() throws FileNotFoundException, IOException, ClassNotFoundException
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
				Class reflectClass = Class.forName("ie.gmit.sw.AlgStrs");

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
			     for(Method newMethod : Methods){

			         // AlgStrs Methods
			         System.out.println("Method Name: " + newMethod.getName());

			         // check AlgStrs for getter
			         if(newMethod.getName().startsWith("get"))
			         {
			             System.out.println("Getter?");
			         }
			         // check AlgStrs for setter
			         else if(newMethod.getName().startsWith("set"))
			         {
			             System.out.println("Setter");
			         }

			         //Getting Return Types
			         System.out.println("Return Type: " + newMethod.getReturnType());

			         Class[] parameterType = newMethod.getParameterTypes();

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
			     System.out.println("Constructors: null");
		         Constructor[] constructors = reflectClass.getConstructors();
		         AlgStrsRefl Ref = new AlgStrsRefl();
		         System.out.println("---------------------------------------------------");
		         return;
	}
	}




