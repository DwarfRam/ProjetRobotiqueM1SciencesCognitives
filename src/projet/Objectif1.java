package projet;

import java.util.Arrays;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Objectif1 implements Behavior {
	
	private boolean camp;
	
	public Objectif1 (boolean c){
		this.camp=c;
	}


	public boolean takeControl() {
		return(Button.RIGHT.isDown());
	}
	
	public void suppress() {
	}
	
	public void action() {
		

	}
}
