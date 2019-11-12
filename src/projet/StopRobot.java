package projet;

import java.util.Arrays;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * Class for the behavior for stop the robot
 * 
 *
 * @author Christian B.
 */
public class StopRobot implements Behavior{
	//private EV3UltrasonicSensor ultrasonic;
	private EV3TouchSensor touch; 
	private EV3ColorSensor color;
	private float [] f;
	private Arbitrator action;
	
	public StopRobot(EV3TouchSensor ts, EV3ColorSensor color, float [] s) {
		this.touch= ts; this.color = color; this.f = s;
		//this.ultrasonic = us;
	}
	
	public void setArbitrator (Arbitrator arby) {
		this.action = arby;
	}
	
	public boolean takeControl() {
		return(Button.ESCAPE.isDown());
	}
	
	public void suppress() {
	}
	
	public void action() {
        LCD.clear();
		LCD.drawString("Time to die", 0,4);
        LCD.asyncRefresh();

		Motor.B.stop(true);
		Motor.C.stop(true);
		
		System.out.println(Arrays.toString(f));

		//ultrasonic.close();
		color.close();
		touch.close();
		
		action.stop();
		System.exit(0);
	}
}
