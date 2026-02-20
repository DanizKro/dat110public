package no.hvl.dat110.display;


import no.hvl.dat110.rpcinterface.TempSensorInterface;
import no.hvl.dat110.rpcinterface.TemperatureCallback;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DisplayDevice extends UnicastRemoteObject implements TemperatureCallback {

	public DisplayDevice() throws RemoteException{
		super();
	}
	
	public void run() {
		
		System.out.println("Display started...");

		try {
			// Get a reference to the registry using the port
			Registry registry = LocateRegistry.getRegistry("localhost", TempSensorInterface.SERVER_PORT);

			// Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
			TempSensorInterface tempSensor = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);

			tempSensor.registerCallback(this);

//			for(int i = 0; i < 10; i++ ){
//				double temp = tempSensor.getTemperature();
//				System.out.println("Display: " + temp);
//				Thread.sleep(1000);
//			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void notifyList(double temp) throws RemoteException {
		System.out.println("Display revieced: " + temp);
	}
}
