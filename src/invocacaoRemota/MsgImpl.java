package invocacaoRemota;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Server-side
public class MsgImpl extends UnicastRemoteObject implements Msg{

	public MsgImpl() throws RemoteException{
		super();
	}
	
	@Override
	public void enviarMensagem(String msg) throws RemoteException {
		System.out.println(msg);
	}

	@Override
	public String lerMensagem() throws RemoteException {
		return "Lendo do objeto remoto";
	}

}
