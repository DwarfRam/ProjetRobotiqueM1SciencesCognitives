package projet;


import lejos.hardware.Button;
import lejos.remote.nxt.BTConnection;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import lejos.robotics.subsumption.Behavior;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class Objectif2 implements Behavior{
	private Robot rob;
	
	public Objectif2 (Robot r){
		this.rob = r;
	}

	@Override
	public boolean takeControl() {
		return(Button.UP.isDown());
	}

	@Override
	public void action() {
		int abs;
		int ord;
		
		BTConnector bt = new BTConnector();
		BTConnection btc = bt.connect("00:16:53:43:4E:26", NXTConnection.PACKET);
		
		//OutputStream os = btc.openOutputStream();
		//ObjectOutputStream oos = new ObjectOutputStream(os);
		//CaseEnvironnement [][] env =  rob.getEnv() ;
		
		//dos.write(env);
		
		
		
	}

	@Override
	public void suppress() {
		
		
	}

}
