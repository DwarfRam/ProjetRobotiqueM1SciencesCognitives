package projet;

//import lejos.remote.nxt.BTConnection;
//import lejos.remote.nxt.BTConnector;
//import lejos.remote.nxt.NXTConnection;
import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;
//import java.io.DataOutputStream;
//import java.io.OutputStream;


public class Objectif2 implements Behavior{

	@Override
	public boolean takeControl() {
		return(Button.UP.isDown());
	}

	@Override
	public void action() {
		//BTConnector bt = new BTConnector();
		//BTConnection btc = bt.connect("00:16:53:43:4E:26", NXTConnection.PACKET);
		
		//OutputStream os = btc.openOutputStream();
		//DataOutputStream dos = new DataOutputStream(os);
		
	}

	@Override
	public void suppress() {
		
		
	}

}
