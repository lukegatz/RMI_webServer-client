import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorChatImpl 
	extends java.rmi.server.UnicastRemoteObject implements ServidorChat {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> mensagens;
	int nMensagens;

	public ServidorChatImpl() throws RemoteException {
		super();
		this.mensagens = new ArrayList<String>();
	}

	public void enviarMensagem(String mensagem) throws RemoteException {
		mensagens.add(mensagem);
	}

	public ArrayList<String> lerMensagem() throws RemoteException {
		return mensagens;
	}

}