package projet;


import lejos.hardware.Button;
import lejos.remote.nxt.BTConnection;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import lejos.robotics.subsumption.Behavior;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * <b>
 * Second objectif : envoi des coordonnées via Bluetooth. 
 * </b>
 * 
 * <p>
 * Il doit être possible d'envoyer les coordonnées d'un robot vers un autre lorsque l'utilisateur appui sur le bouton bas. 
 * </p>
 * <p>
 * Cette classe implémente la classe Behavior car correspond à un comportement. 
 * </p>
 */
public class Objectif2 implements Behavior{
	private Robot rob;
	
	/**
	 * 
	 * @param r : Robot considéré (sauvageon ou garde)
	 */
	public Objectif2 (Robot r){
		this.rob = r;
	}
	/**
	 * Action permettant de lancer le comportement 
	 */
	@Override
	public boolean takeControl() {
		return(Button.UP.isDown());
	}
	/**
	 * Ce qui est effectué lorsque le comportement est établi (envoi des coordonnées)
	 * @see BluetoothEmettor
	 * @see BluetoothReceptor
	 */
	@Override
	public void action() {

		
		BTConnector bt = new BTConnector();
		BTConnection btc = bt.connect("00:16:53:43:4E:26", NXTConnection.PACKET);
		
		
		
		OutputStream os = btc.openOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CaseEnvironnement [][] env =  rob.getEnv() ;
		
		try {
			oos.writeObject(env);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	@Override
	public void suppress() {
		
		
	}

}
