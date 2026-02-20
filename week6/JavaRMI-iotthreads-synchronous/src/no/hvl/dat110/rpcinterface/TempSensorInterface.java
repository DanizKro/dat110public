package no.hvl.dat110.rpcinterface;

/**
 * dat110: DS Lab2
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface TempSensorInterface extends Remote {
	
	public static final int SERVER_PORT = 9091;
	public static final String REMOTE_IFACE_NAME = "TempSensorInterface";

	public void setTemperature(double temp) throws RemoteException;
	public double getTemperature() throws RemoteException;
	public void registerCallback(TemperatureCallback callback) throws RemoteException;
}
