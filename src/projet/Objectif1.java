package projet;

import java.util.Arrays;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Objectif1 implements Behavior {
	
	private Environnement env;
	private boolean camp;
	
	public Objectif1 (boolean c, Environnement e){
		this.camp = c;
		this.env = e;
	}


	public boolean takeControl() {
		return(Button.RIGHT.isDown());
	}
	
	public void suppress() {
	}
	
	public void action() {
		if (camp){      // 0 = Thenn et 1 = Winterfell
			
		}
		

	}
}
