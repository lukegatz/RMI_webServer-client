import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Servidor {
	public Servidor(){
		try {
			Registry registry = LocateRegistry.createRegistry(9999);
			ServidorChat server = new ServidorChatImpl();
			Naming.rebind("rmi://localhost:9999/ServidorChat",server);
			JOptionPane.showMessageDialog(null, 
					"Servidor inicializando...");

		} catch (Exception e){
			System.err.println("Trouble: " + e);
		}

	}
	
	// Starta o servidor
	public static void main (String args[]){
		new Servidor();
	}

}