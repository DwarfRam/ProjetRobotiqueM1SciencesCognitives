package projet;

import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.robotics.navigation.MovePilot;

public class Objectif1 implements Behavior {
	private boolean camp; // True == Garde de nuit 
	private MovePilot pilot;

	public Objectif1 (boolean c, MovePilot p){
		this.camp = c;
		this.pilot = p;
	}

	public boolean takeControl() {
		return(Button.RIGHT.isDown());
	}
	
	public void suppress() {
	}
	
	public void action() {
		
		
		pilot.setLinearSpeed(60);
		pilot.setAngularSpeed(25);     
		
		if (!camp) {
			pilot.travel(540);
		}
		else {
			pilot.travel(405);
			pilot.rotate(-81);
			pilot.travel(120);
		}		

	}
}
