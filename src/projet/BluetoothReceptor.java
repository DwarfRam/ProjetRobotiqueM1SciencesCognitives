package projet;

//import java.io.DataInputStream;
import java.io.InputStream;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import java.io.ObjectInputStream;
;

public class BluetoothReceptor {

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
			//OutputStream os = btc.openOutputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			//DataOutputStream dos = new DataOutputStream(os);

			//CaseEnvironnement valeur = ois.read(); A MODIFIER
			

			ois.close();
			//dos.close();
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
