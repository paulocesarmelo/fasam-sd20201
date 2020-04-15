package invocacaoRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MsgClient {

	public static void main(String[] args) {
		
		try {
			Msg m = (Msg) Naming.lookup("rmi://localhost/msgService");
			
			System.out.println(m.lerMensagem());
			
			m.enviarMensagem("Java RMI funcionando!");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
