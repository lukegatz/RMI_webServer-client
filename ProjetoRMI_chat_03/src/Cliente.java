import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.util.ArrayList;
import java.rmi.RemoteException;

public class Cliente {
	
	private static Scanner in = new Scanner(System.in);
	private static final String endereco = "rmi://localhost:9999/ServidorChat";

	public static void main( String args[] ) {
		try {
			final ServidorChat chat = (ServidorChat) 
					Naming.lookup( endereco );

			String nome;
			String msg = "";

			System.out.println("Digite seu nome:");

			nome = in.nextLine();

			Thread thread = new Thread(new Runnable() {
				int cont = chat.lerMensagem().size();
				@Override
				public void run() {
					try {
						while(true){
							if (chat.lerMensagem().size() > cont){
								System.out.println(chat.lerMensagem().get(chat.lerMensagem().size()-1));
								cont++;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();

			while(msg != "exit"){

				System.out.println(nome+": ");

				msg = in.nextLine();

				chat.enviarMensagem(nome+": "+msg);
				// System.out.println(chat.lerMensagem().get(cont));
			}
			
		} catch( Exception e ) {
			e.printStackTrace();
		} finally {
			in.close(); 
		}
	}
}