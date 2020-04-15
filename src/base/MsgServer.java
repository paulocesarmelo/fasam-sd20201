package base;

import java.rmi.Naming;

public class MsgServer {

	public MsgServer(){
		try {
			Msg m = new MsgImpl();
			Naming.rebind("rmi://localhost:1099/msgService", m);
		} catch (Exception e) {
			System.out.println("Throuble: " +e);
		}
	}
	
	public static void main(String[] args){
		new MsgServer();
	}
}
