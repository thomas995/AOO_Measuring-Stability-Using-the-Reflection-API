package ie.gmit.sw;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public abstract class compStringableImpl<Algo_DLHDL> extends UnicastRemoteObject implements stringservice
{
	protected compStringableImpl() throws RemoteException
	{
		super();
	}

	private static final long serialVersionUID = 1L;
	private Map<String, Algo_DLHDL> algorithms = new HashMap<String, Algo_DLHDL>(); // DLHDL is the 3 string algorithms

	public resultator compStrs(String stringone, String stringtwo, String algoResult)
	{
		resultator r = null;
		// try catch statement for error handling
		try
		{
			r = new resultatorimpl();
		}

		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		// returns the value to be used in other classes
		return r;
	}
}


