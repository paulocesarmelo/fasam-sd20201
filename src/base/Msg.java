package base;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Msg extends Remote{
	
	public void enviarMensagem( String msg ) throws RemoteException;
	public String lerMensagem() throws RemoteException;

}
