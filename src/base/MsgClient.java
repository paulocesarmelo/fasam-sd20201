package base;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MsgClient {

	public static void main(String args[]){
		try {
			Msg m = (Msg) Naming.lookup("rmi://localhost/msgService");
			System.out.println(m.lerMensagem());
			m.enviarMensagem("Java RMI funcionando!!");
		} catch( MalformedURLException e ) {  
            System.out.println();  
            System.out.println( "MalformedURLException: " + e.toString() );  
        }  
        catch( RemoteException e ) {  
            System.out.println();  
            System.out.println( "RemoteException: " + e.toString() );  
        }  
        catch( NotBoundException e ) {  
            System.out.println();  
            System.out.println( "NotBoundException: " + e.toString() );  
        }  
        catch( Exception e ) {  
            System.out.println();  
            System.out.println( "Exception: " + e.toString() );  
        }  
	}
	
}
