package no.hvl.dat110.rpcserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import no.hvl.dat110.rpcinterface.TempSensorInterface;
import no.hvl.dat110.tempsensor.TemperatureSensor;

/**
 * For demonstration purpose in dat110 course
 */

public class TempSensorImpl extends UnicastRemoteObject implements TempSensorInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double temp;
	
	public TempSensorImpl() throws RemoteException {
		super();
		temp=0.0;
	}

	@Override
	public synchronized void setTemperature(int temp) throws RemoteException{
		this.temp = temp;
	}

	@Override
	public synchronized double getTemperature() throws RemoteException {
		return temp;
	}
}
