package no.hvl.dat110.rpcserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import no.hvl.dat110.rpcinterface.TempSensorInterface;
import no.hvl.dat110.rpcinterface.TemperatureCallback;

/**
 * For demonstration purpose in dat110 course
 */

public class TempSensorImpl extends UnicastRemoteObject implements TempSensorInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double temp;

	private List<TemperatureCallback> subscriberList = new ArrayList<>();
	
	public TempSensorImpl() throws RemoteException {
		super();
		temp=0.0;
	}

	@Override
	public synchronized void setTemperature(double temp) throws RemoteException{
		this.temp = temp;
		for(TemperatureCallback e : subscriberList){
			e.notifyList(temp);
		}
	}

	@Override
	public synchronized double getTemperature() throws RemoteException {
		return temp;
	}

	@Override
	public synchronized void registerCallback(TemperatureCallback subscriber) throws RemoteException {
		subscriberList.add(subscriber);
	}
}
