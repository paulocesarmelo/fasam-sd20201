package invocacaoRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MsgServer {

	public MsgServer() {
		
		try {
			
			//instância um objeto remoto
			Msg m = new MsgImpl();
				
			//inserindo o objeto como registro no registry
			Naming.rebind("rmi://localhost:1099/msgSevice", m);
			
			
		} catch (RemoteException e) {
			System.out.println("Remote exception: "+e.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new MsgServer();
	}
	
}
