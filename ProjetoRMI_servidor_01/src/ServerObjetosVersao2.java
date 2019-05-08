import java.net.MalformedURLException;
import java.rmi.Naming; 
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry; 
import java.util.Scanner;
public class ServerObjetosVersao2 {
	
	private String str = null;
	private String endereco = "rmi://localhost:9999/MensageiroService";
	private Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {   
		System.err.print("Servidor ativo...");
		System.out.println("");
		new ServerObjetosVersao2(); 
	} 
	
	public ServerObjetosVersao2() { 
		try {  
			Mensageiro objeto1 = new MensageiroImpl();
			//registra o servidor  pela porta 9999, evitando de 
			//faze-lo no console usando RMIC
			LocateRegistry.createRegistry(9999);
			Naming.rebind(endereco, objeto1);
			// mensagem recebida foi lida
			do {
//				str = objeto1.lerMensagem();
				// enviar mensagem, utilizando Scanner ( InputStream )
				System.out.println("\nDigite uma mensagem para o cliente: " + "\n");
				str = in.nextLine();
				// realizar o envio ( como referenciar o objeto??? )
				objeto1.enviarMensagem(str);
			} while(!str.equalsIgnoreCase("sair"));
			shutDown(); // método para encerrar o servidor
		} catch( Exception e ) { 
			System.err.println(" Erro: " + e );
		}  
	} // fim do construtor
	
	public void shutDown() 
			throws RemoteException, MalformedURLException, NotBoundException {
		Thread t = new Thread();
		t.start();
		Naming.unbind(endereco);
		System.exit(0);
	}
}
