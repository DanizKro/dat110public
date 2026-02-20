package no.hvl.dat110.rpcinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureCallback extends Remote {

    void notifyList(double temp) throws RemoteException;

}
