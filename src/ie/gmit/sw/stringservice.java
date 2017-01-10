package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface stringservice extends Remote
{
	// takes in the parameters from the website, first string, second string and then whichever algorithm the user decided
	public resultator inputStringComparison(String s, String t, String algo) throws RemoteException;
}
