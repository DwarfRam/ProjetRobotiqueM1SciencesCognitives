package projet;



import java.io.OutputStream;
import lejos.hardware.Button;
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.remote.nxt.BTConnection;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import java.io.ObjectOutputStream;

/**
 * <b>
 * Cette classe permet de paramétrer l'envoi par bluetooth, côté émetteur. 
 * </b>
 * 
 *
 */
public class BluetoothEmettor {
	private static CaseEnvironnement [][] environnement;
	/**
	 * Permet d'établir la connexion entre les deux appareils.  
	 * Une fois la connexion établie, les données peuvent être envoyées. 
	 * 
	 * @param args : données à envoyer. 
	 */
	public static void main(String[] args) {
		String connected = "Connected";
		//String waiting = "Waiting";
		EV3 ev = LocalEV3.get();
		System.out.println("--"+ev.getName()+"--");
		Button.RIGHT.waitForPressAndRelease();
		try {
			
			//LCD.drawString(waiting, 0, 0);
			//LCD.refresh();
			//droite = 00:16:53:43:4E:26
			//gauche = 00:16:53:43:8E:49
			BTConnector bt = new BTConnector();
			BTConnection btc = bt.connect("00:16:53:43:EB:88", NXTConnection.PACKET);//le premier parametre est l'adresse du recepteur affiche sur l'ecra de l'emetteur apres association (pair) bluetooth


			LCD.clear();
			LCD.drawString(connected, 0, 0);
			LCD.refresh();

			
			OutputStream os = btc.openOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os); // Changement en OBJECTOutputStream 
			
			System.out.println("\n\nEnvoi");
			oos.writeObject(environnement); // Envoi un objet dans le flux - ajouter objet à envoyer COMMENT ? 
			oos.flush(); // force l'envoi
			System.out.println("\nEnvoye");
			//dis.close();
			oos.close();
			btc.close();
			LCD.clear();
			
		} catch (Exception e) {
		}
	}

}
