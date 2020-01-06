package projet;

//import java.io.DataInputStream;
import java.io.InputStream;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import java.io.ObjectInputStream;
;
/**
 * <b>
 * Classe permettant de parametrer l'envoi par bluetooth, cote récepteur. 
 * </b>
 * 
 *
 */
public class BluetoothReceptor {
	private static byte[] environnement;
	/**
	 * Permet d'etablir la connexion entre les deux appareils.  
	 * Une fois la connexion etablie, les donnees peuvent etre reçues. 
	 * 
	 * @param args : donnees à recevoir. 
	 */
	
	public static void main(String[] args) {
		String connected = "Connected";
		//String waiting = "Waiting";
		
		try {
			//LCD.drawString(waiting, 0, 0);
			//LCD.refresh();

			BTConnector bt = new BTConnector();
			NXTConnection btc = bt.waitForConnection(100000, NXTConnection.PACKET);

			if (btc !=null) {
			LCD.clear();
			LCD.drawString(connected, 0, 0);
			LCD.refresh();

			InputStream is = btc.openInputStream();
			
			ObjectInputStream ois = new ObjectInputStream(is); // Changement en OBJECTInputStream
			

			//CaseEnvironnement valeur = 
			ois.read(environnement); 

			ois.close();
			
			btc.close();
			//System.out.println(valeur);
			Button.RIGHT.waitForPressAndRelease();
			LCD.clear();
			} else {
				System.out.println("Pas de connexion");
				Button.RIGHT.waitForPressAndRelease();
			}
		} catch (Exception e) {
		}
	}

}
