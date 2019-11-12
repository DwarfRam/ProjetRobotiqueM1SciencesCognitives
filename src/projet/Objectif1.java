package projet;

import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.MovePilot;

public class Objectif1 implements Behavior {
	EV3ColorSensor Couleur = new EV3ColorSensor(SensorPort.S3);
	
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
		//int valeur = Couleur.getColorID();
		pilot.setLinearSpeed(5);
		pilot.setAngularSpeed(5);
		
	//Utilisation de la longueur des cases
		
		if (camp){  //Garde de nuit 
			//en positionnant le capteur couleur du robot dans le coin haut droit de la case blanche de depart
			pilot.travel(40);
			pilot.rotate(90);
			pilot.travel(40);
			
			LCD.drawString("Arrivee !", 3,4);
		}

		else {
			//en positionnant le capteur couleur du robot dans le coin haut droit de la case blanche de depart
			pilot.travel(40);
			pilot.rotate(180);
			pilot.travel(40);
			LCD.drawString("Arrivee !", 3,4);
		}
        
        
        
    /* Utilisation du capteur de couleur, m�thode plus compliqu�e     
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
