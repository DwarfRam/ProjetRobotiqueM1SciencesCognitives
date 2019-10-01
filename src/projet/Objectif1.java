package projet;

import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class Objectif1 implements Behavior {
	EV3ColorSensor Couleur = new EV3ColorSensor(SensorPort.S3);
	
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
		int valeur = Couleur.getColorID();
		Motor.B.setSpeed(100);		
        Motor.C.setSpeed(100);
         
		if (camp){      // 0 = Thenn et 1 = Winterfell
			if (valeur== Color.WHITE ){ //V�rification que le robot est bien sur la case d�part
				while (valeur == Color.WHITE){
					Motor.B.forward();
					Motor.C.forward();
				}
				if (valeur == Color.BLACK){
					// changer de case dans tableau
					while (valeur == Color.BLACK){
						Motor.B.forward();
						Motor.C.forward();
					}
				}
				if (valeur == Color.GREEN){
					env.setCase(valeur); 
					while (valeur == Color.GREEN || valeur == Color.BLACK){
						Motor.B.forward();
						Motor.C.forward();
					}
					if (valeur == Color.BLUE){
						while (valeur == Color.GREEN){
							Motor.B.backward();
							Motor.C.backward();
						}
						Motor.C.rotate(90, true); // a changer avec chassis..
						while (valeur == Color.RED){
							Motor.B.forward();
							Motor.C.forward();
						}
					}
				}
			}
			LCD.drawString("Vous etes arriv� au camp militaire", 3, 4); 
		} else { //Thenn
			while (valeur != Color.RED){
				Motor.B.forward();
				Motor.C.forward();
			}
			LCD.drawString("Vous etes arriv� au camp militaire", 3, 4); 
		}
		

	}
}
