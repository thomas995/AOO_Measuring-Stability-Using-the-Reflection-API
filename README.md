# AOO_Measuring-Stability-Using-the-Reflection-API
The main aim of this project is to be able to read in any JAR file that the user selects and have information about it be displayed in a table.
This information should be;

1.The class files found in the JAR

2.The Afferent Couplings

3.The Efferent Couplings

4.The classes stability

All of the values displayed should have a value between 0(being that the class is stable) or 1(being that the class is unstable).

##Executing the Code
Taking the source code from the src folder, you execute the Runner class. This opens a window. In this window you already have the option to see a default jar file contents through the console by clicking on the JAR STATS button. This displays the contents of the string-service.jar which was the JAR file from a previous project. To use one of your own JAR files, you select the Browse... button and move to the directory which contains the JAR file you want to see the contents of. Once you have it selected and the location of the JAR is in the address box, you click on JAR STATS once again. This time, you should have a window popping up, which contains a table telling you all about the JAR[see points 1 through 4 from earlier]. You can do this with any type of JAR file that contains JAVA classes.

MetricsChecker and MetricCheckerCalc are used to read in the unique jar and take in the values for the table.

AppSummary, AppWindow, CustomControl, Runner and TypeSummaryTableModel were given to us to start us off.

Every class that is not the above or end in 'Refl' is from a previous project. These are used for the default jar.

Every class ending in 'Refl' was created so that you could read in the file and get the unique attributes within it.

Extra information on what each class in the project is doing is included in comments within the source code.


#Software Needed
 http://metrics.sourceforge.net - Metrics ----> Go to help on the task bar of eclipse, install new software and enter in the link provided, follow the step. Then right click on the project once installed, go to properties and when you click on Metrics, enable it.
 
 http://andrei.gmxhome.de/eclipse/ - JDepend -----> Do the same as above and follow the steps to install onto Eclipse. Ensure that you are using JUnit 4 so that testing can be done, @Test does not work on previous Junit versions

#References 
http://andrei.gmxhome.de/eclipse.html- JDepend ---> used to compiles the Junit test 'Test_AffEff'

https://github.com/thomas995/Multi-Threaded-Cypher-Breaker/tree/master/OOP/dist - railfence.jar

https://github.com/thomas995/DistSys-AsyncRMI_StringComparisonService - string-service.jar

https://www.youtube.com/watch?v=agnblS47F18 - Java Reflection Help

