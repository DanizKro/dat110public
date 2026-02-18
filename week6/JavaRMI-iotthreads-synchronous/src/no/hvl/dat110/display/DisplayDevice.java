package no.hvl.dat110.display;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DisplayDevice extends Thread {
		
	
	public void run() {
		
		System.out.println("Display started...");

		try {
			// Get a reference to the registry using the port
			Registry registry = LocateRegistry.getRegistry("localhost", TempSensorInterface.SERVER_PORT);

			// Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
			TempSensorInterface tempSensor = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);

			for(int i = 0; i < 10; i++ ){
				double temp = tempSensor.getTemperature();
				System.out.println("Display: " + temp);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
