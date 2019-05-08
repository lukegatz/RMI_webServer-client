import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.NotBoundException; 
import java.rmi.RemoteException; 
import java.rmi.registry.LocateRegistry;
import java.util.Scanner; 
public class MensageiroClient { 

	private static Mensageiro objeto1 = null;
	private static Scanner in = new Scanner(System.in);
	private static String msg = null;
	private static String endereco = "rmi://localhost:9999/MensageiroService";

	public static void main(String[] args) { 

		try { 
			//obter uma referência para objeto servidor
			LocateRegistry.getRegistry("localhost");
			System.out.println("Digite a sua mensagem ou digite sair para finalizar: ");
			do {
				msg = in.nextLine();
				objeto1 = (Mensageiro) Naming.lookup( endereco ); 
				objeto1.enviarMensagem( msg );
			} while(!msg.equalsIgnoreCase("sair"));  
		} catch (MalformedURLException | RemoteException | NotBoundException e) {    
			e.printStackTrace();
			System.out.println("problema de conexão");   
		} 
	}
}