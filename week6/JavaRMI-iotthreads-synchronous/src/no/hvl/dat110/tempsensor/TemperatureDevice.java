package no.hvl.dat110.tempsensor;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}
	
	public void run() {
		
		System.out.println("temperature device started");

        try {
			// Get a reference to the registry using the port
			Registry registry = LocateRegistry.getRegistry("localhost", TempSensorInterface.SERVER_PORT);

			// Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
			TempSensorInterface tempSensor = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);

			for(int i = 0; i < 10; i++){
				int temp = sn.read();
				tempSensor.setTemperature(temp);
				Thread.sleep(990);   // oppdaterer ny verdi rett før den leses i DisplayDivice med 990 msw
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
