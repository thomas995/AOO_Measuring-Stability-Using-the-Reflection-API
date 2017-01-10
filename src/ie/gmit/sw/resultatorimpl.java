package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class resultatorimpl extends UnicastRemoteObject implements resultator // uses the implemented methods from the resultator 
{
	private static final long serialVersionUID = 1L; // allows the class to be found again at a much quicker speed

	// private variables
	private boolean processed;
	private String result;

	protected resultatorimpl() throws RemoteException
	{
		super(); // super class
	}

	// returns the result that was inputted
	@Override
	public String getResult() throws RemoteException
	{
		return result; 
	}

	// stores the result that was inputted
	@Override
	public void setResult(String result) throws RemoteException
	{
		this.result = result;
	}

	// returns the value that is processed
	public boolean isProcessed()
	{
		return processed;
	}
	
	// stores the value that was processed to be used 
	public void setProcessed()
	{
		this.processed = true;
	}

}