import java.rmi.Naming; 
import java.rmi.registry.LocateRegistry; 
public class ServerObjetos { 
	public static void main(String[] args) {   
		System.out.print("Servidor ativo...");   
		new ServerObjetos(); 
	} 
	public ServerObjetos() { 
		try {  
			Mensageiro objeto1 = new MensageiroImpl();
			String str = null;
			String endereco = "rmi://localhost:9999/MensageiroService";
			//registra o servidor  pela porta 9999, evitando de 
			//faze-lo no console usando RMIC
			LocateRegistry.createRegistry(9999);
			Naming.rebind(endereco, objeto1);
			str = objeto1.lerMensagem();
		} catch( Exception e ) { 
			System.out.println(" Erro: " + e );
		}  
	}
}
