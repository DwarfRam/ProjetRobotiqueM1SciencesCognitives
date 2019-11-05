package projet;

import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class Objectif1 implements Behavior {
	EV3ColorSensor Couleur = new EV3ColorSensor(SensorPort.S3);
	
	private Environnement env;
	private boolean camp;
	private MovePilot pilot;
		
	public Objectif1 (boolean c, Environnement e, MovePilot p){
		this.camp = c;
		this.env = e;
		this.pilot = p;	
	}


	public boolean takeControl() {
		return(Button.RIGHT.isDown());
	}
	
	public void suppress() {
	}
	
	public void action() {
		//int valeur = Couleur.getColorID();
		pilot.setLinearSpeed(5);
		pilot.setAngularSpeed(5);
		
	//Utilisation de la longueur des cases
		
		if (camp){  //Winterfell
			//en positionnant le capteur couleur du robot dans le coin haut droit de la case blanche de départ
			pilot.travel(40);
			pilot.rotate(90);
			pilot.travel(14);
			
			LCD.drawString("Arrivée !", 3,4);
		}

		else {
			//en positionnant le capteur couleur du robot dans le coin haut droit de la case blanche de départ
			pilot.travel(52);
			pilot.rotate(90);
			LCD.drawString("Arrivée !", 3,4);
		}
        
        
        
    /* Utilisation du capteur de couleur, méthode plus compliquée     
		if (camp){      // 0 = Thenn et 1 = Winterfell
			if (valeur== Color.WHITE ){ //Vérification que le robot est bien sur la case départ
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
					env.setCase(valeur, 1); 
					while (valeur == Color.GREEN || valeur == Color.BLACK){
						Motor.B.forward();
						Motor.C.forward();
					}
					if (valeur == Color.BLUE){
						while (valeur == Color.GREEN){
							Motor.B.backward();
							Motor.C.backward();
						}
						pilot.rotate(90); // a changer avec chassis..
						while (valeur == Color.RED){
							Motor.B.forward();
							Motor.C.forward();
						} //peut etre rajouter d'avancer un peu pour bien etre sur la case?
						env.setCase(valeur, 1); 
					}
				}
			}
			LCD.drawString("Vous etes arrive", 3, 4); 
		} else { //Thenn
			while (valeur != Color.RED){
				Motor.B.forward();
				Motor.C.forward();
			}
			env.setCase(valeur, 1); 
			LCD.drawString("Vous etes arrive", 3, 4); 
		}
		*/

	}
}
