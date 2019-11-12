package projet;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Main {
	public static void main(String[] args) {
		
		Robot warrior = null;
		
		LCD.drawString("Bas = Garde", 0,0);
		LCD.drawString("Haut = Sauvageon", 0,4);
        LCD.asyncRefresh();
        Button.waitForAnyPress();
        if (Button.UP.isDown())
        {
        	warrior = new Robot("Sauvageon", false);	
        }else if (Button.DOWN.isDown())
        {
        	warrior = new Robot("Garde", true);
        }
        LCD.clear();
        LCD.drawString("camps choisi", 0,4); // ok jusqu'ici
        LCD.asyncRefresh();
        Button.waitForAnyPress();
        
        warrior.CreationMap();//erreur ici au lancement (null pointer exception)
        
        LCD.clear();
        LCD.drawString("Maps creer", 0,4);
        LCD.asyncRefresh();
        Button.waitForAnyPress();
        
        
        Wheel wheel1 = WheeledChassis.modelWheel(Motor.B, 56.).offset(-60);
        Wheel wheel2 = WheeledChassis.modelWheel(Motor.C, 56.).offset(60);
        Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2}, 2);
        MovePilot pilot = new MovePilot(chassis);
        pilot.setLinearSpeed(30.);
        pilot.setAngularSpeed(30.);
        
		EV3TouchSensor ts= new EV3TouchSensor(SensorPort.S1);
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S3);
		float[] s = new float[4];							// 0..2 couleur, 3 ultrason
		
		Behavior[] bArray= new Behavior [3];				// tableau de 3 Behavior (= 3 comportements)
		
		//Behavior bSearchLine = new SearchLine(pilot, color, ts);
		//Behavior bFollowBlackLine = new FollowBlackLine(color, ts);
		Behavior bCollision = new HitSomething(ts, s);
		Behavior bStop = new StopRobot(ts, color, s);
		Behavior bObjectif1 = new Objectif1(warrior.getTeam(), pilot); //Ajouter parametres 

		bArray[0] = bObjectif1;
		bArray[1] = bCollision;
		bArray[2] = bStop;
		
		Arbitrator arby= new Arbitrator(bArray);
		
		if (bStop instanceof StopRobot) {
			StopRobot b = (StopRobot)bStop;
			b.setArbitrator(arby);
		}
		
		arby.go();
	}

}
