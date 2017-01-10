package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class stringserviceimpl extends UnicastRemoteObject implements stringservice
{
		private resultator r;
		private static final long serialVersionUID = 1L; 

		public stringserviceimpl() throws RemoteException
		{
			
		}

		// deals with the user input in the two textboxes for String S and String T
		@Override
		public resultator inputStringComparison(String stringone, String stringtwo, String algo) throws RemoteException
		{
			r = new resultatorimpl(); 
			//InputCompare inpCom = new InputCompare(stringone, stringtwo, r, algo);
			//Thread comp = new Thread(inpCom);
			//comp.start();
				
			return r;  // return the values from the class
		}

	}