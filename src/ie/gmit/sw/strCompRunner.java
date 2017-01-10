package ie.gmit.sw;

import java.rmi.RemoteException;

public class strCompRunner implements Runnable // allows the class to be run as an executable
{	
	resultator r;
	compStringable inputStringComparison;
	String stringone;
	String stringtwo;

	public strCompRunner(resultator r, compStringable inputStringComparison, String stringone, String stringtwo) // constructor for the class to populate the values
	{
		// instantiates methods so that they can be used within the other methods of the class
		this.r = r;
		this.inputStringComparison = inputStringComparison;
		this.stringone = stringone;
		this.stringtwo = stringtwo;
	}

	@Override
	public void run() 
	{
		try 
		{
			r.setResult(inputStringComparison.doMatch(stringone, stringtwo)); // calls in the implemented methods from compStringable
			try 
			{
				Thread.sleep(10000); // sleeps/pauses the application for 10 seconds as specificed in the project spec to make it seem asynchronous
			}
			// Try catch error handling
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			r.setProcessed();
			System.out.println(r + "is processed");
		}
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
	}
	
}
