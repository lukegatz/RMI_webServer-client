import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
public class MensageiroImpl extends UnicastRemoteObject 
implements Mensageiro { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MensageiroImpl() throws RemoteException {   
		super(); 
	}
	
	public void enviarMensagem(String msg) throws RemoteException {   
		System.out.printf("\n%s", msg ); 
	} 
	
	public String lerMensagem() throws RemoteException {   
		return "Não é um hello world!"; 
	}

	public void enviarMensagemParaTodos(String endereco, String msg)
		throws RemoteException {
		// TODO Auto-generated method stub
		
	} 
}
