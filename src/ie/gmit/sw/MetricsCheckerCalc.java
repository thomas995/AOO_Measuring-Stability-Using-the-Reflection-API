package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


/**
 * @author Thomas
 *
 */
public class MetricsCheckerCalc
{
	// variables
	private HashMap<String, MetricsChecker> classMetrics = new HashMap<>();
    private String JAR_Path;


    /**
     * @param pathname
     */
    public MetricsCheckerCalc(String pathname)
    {

    	// save the jar pathname
        this.JAR_Path = pathname;

        // add the classes to the map
        addCNames();

        // calculate the metrics for classes in map
        calculateBasicMetric();

    }
    // Class for populating the table
    /**
     * @return
     */
    public Object[][] getMetricData() 
    {

        int i = 0; // sets all the values to zero
        Object[][] data = new Object[classMetrics.size()][4]; // populates the table with 4 columns

        for(MetricsChecker mc : classMetrics.values())
        {
        	// values being used in the table
            data[i][0] = mc.getClassName();  // class name
            data[i][1] = mc.getStability(); //stability
            data[i][2] = mc.getAfferentCouplings();  // afferent
            data[i][3] = mc.getEfferentCouplings();   // efferent


            i++; // increment counter by one
        }
        return data; // returns value for data from the table
    }

    /**
     *
     */
    private void addCNames()
    {
        int i = 0; // sets it initially to zero

        try
        {

            // new instance of File called file which takes in the value set for JAR_Path
            File file  = new File(JAR_Path);

            // create inputStream to read in file
            JarInputStream in = new JarInputStream(new FileInputStream(file));

            // reads in next value of JAR
            JarEntry next = in.getNextJarEntry();

            // while the next value of the JAR is not null
            while (next != null)
            {
                // if file extension ends in .class
                if (next.getName().endsWith(".class"))
                {
                	// ... then remove that extenion
                    String name = next.getName().replaceAll("/", "\\.");
                    name = name.replaceAll(".class", "");

                    // if class has a $ in its name, remove it
                    if (!name.contains("$")) name.substring(0, name.length() - ".class".length());

                    classMetrics.put(name, new MetricsChecker());

                    classMetrics.get(name).setClassName(name);

                    i++; // increments the number of classes by one
                }

                // get next entry
                next = in.getNextJarEntry();
            }

        }
        // error handling
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void calculateBasicMetric()
    {
        try
        {
            // get handle on jar file
            File file = new File(JAR_Path);

            // creates path to where the file you have selected is located on your machine
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            // Classloader allows you to access files from the URL[urls]
            ClassLoader cl = new URLClassLoader(urls);

            // return a fixed set of keys for the map
            for (String className : classMetrics.keySet())
            {
                // loads the specific classes in this instance
                Class cls = Class.forName(className, false, cl);

                // analyse class to calculate eff and aff couplings
                analyseClass(cls);
            }
        }
        // error handling
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void analyseClass(Class cls)
    {
        int efferentCouplings = 0;

        boolean iface = cls.isInterface();

        Class[] interfaces = cls.getInterfaces(); //Get interface
        for(Class i : interfaces) // for each
        {
            if(classMetrics.containsKey(i.getName()))
            {

                efferentCouplings++; // increases efferent coupling by one

                // increment afferent couplings for interface
                MetricsChecker m = classMetrics.get(i.getName());
                m.setAfferentCouplings(m.getAfferentCouplings() + 1);
            }
        }
        Constructor[] cons = cls.getConstructors(); //Get the set of constructors
        Class[] constructorParams;

        // for each constructor, get it's parameters
        for(Constructor c : cons)
        {
            //System.out.println("Contructor: " + c.getName());
            constructorParams = c.getParameterTypes(); //Get the parameters
            for(Class param : constructorParams){

                if(classMetrics.containsKey(param.getName()))
                {
                    // increment outdegree
                    efferentCouplings++;

                    // increment indegree for other class
                    MetricsChecker mc = classMetrics.get(param.getName());
                    mc.setAfferentCouplings(mc.getAfferentCouplings() + 1);
                }
            }
        }
        Field[] fields = cls.getFields(); //Get the fields / attributes

        for(Field f : fields)
        {

            if(classMetrics.containsKey(f.getName()))
            {

                // increment outdegree
                efferentCouplings++;

                // increment indegree
                MetricsChecker mc = classMetrics.get(f.getName());
                mc.setAfferentCouplings(mc.getAfferentCouplings() + 1);
            }
        }
      //Get the set of methods
        Method[] methods = cls.getMethods();
        Class[] methodParams;

        // outputs all return types
        for(Method m : methods)
        {
        	// method returned
            Class methodReturnType = m.getReturnType();

            if(classMetrics.containsKey(methodReturnType.getName()))
            {
                // increment efferent couplings
                efferentCouplings++;

                // increment afferent couplings
                MetricsChecker mc = classMetrics.get(methodReturnType.getName());
                mc.setAfferentCouplings(mc.getAfferentCouplings() + 1);
            }

          //Get parameters from methods
            methodParams = m.getParameterTypes();
            for(Class mp : methodParams)
            {
                if(classMetrics.containsKey(mp.getName()))
                {
                    // increment efferent couplings
                    efferentCouplings++;

                    // increment afferent couplings
                    MetricsChecker mc = classMetrics.get(mp.getName());
                    mc.setAfferentCouplings(mc.getAfferentCouplings() + 1);
                }
            }
        }
        classMetrics.get(cls.getName()).setEfferentCouplings(efferentCouplings);
    }
}