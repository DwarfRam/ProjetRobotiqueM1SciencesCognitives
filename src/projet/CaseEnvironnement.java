package projet;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;

public class CaseEnvironnement {
	
	private int color;
	private int size;
	private int cost;
	
	public CaseEnvironnement(int col, int dim, int cout){
		this.color = col;
		this.size = dim;
		this.cost = cout;
	}
	
	public void setColor(int c){
		color = c;
	}
	
	public void calibrationColor(){
		LCD.drawString("Bonjour", 3, 4);
		Button.waitForAnyPress();
		LCD.clear();
		EV3ColorSensor capteurCouleur;
		capteurCouleur=new EV3ColorSensor(SensorPort.S3);
		SensorMode valeur = capteurCouleur.getRGBMode();
		float[] sample = new float [3];//valeur.sampleSize()];
		//int couleur = Color.WHITE;
		
		valeur.fetchSample(sample,0);
		LCD.drawString("R: " + sample[0]*1000, 1, 1);
		LCD.drawString("G: " + sample[1]*1000, 1, 2);
		LCD.drawString("B: " + sample[2]*1000, 1, 3);
		
		//Vert
		if ( (sample[0]*1000<95) && (sample[1]*1000>150) && (sample[1]*1000<170) && (sample[2]*1000<50)) {
			LCD.drawString("Case verte", 3, 4);
			color = Color.GREEN;
		}
		
		//Bleu
		else if ( (sample[0]*1000<95) && (sample[1]*1000<60) && (sample[2]*1000<100) && (sample[2]*1000<50)) {
			LCD.drawString("Case bleue", 3, 4);
			color = Color.BLUE;
		}
		//Rouge
		else if ( (sample[0]*1000<273) && (sample[0]*1000>250) && (sample[1]*1000<40) && (sample[2]*1000<25)) {
			LCD.drawString("Case rouge", 3, 4);
			color = Color.RED;
		}
		
		//Orange
		else if ( (sample[0]*1000<252) && (sample[0]*1000>238) && (sample[1]*1000<80) && (sample[2]*1000<30)) {
			LCD.drawString("Case orange", 3, 4);
			color = Color.ORANGE;
		}
		
		//Blanc
		else if ( (sample[0]*1000>240) && (sample[1]*1000>240) && (sample[2]*1000>150)) {
			LCD.drawString("Case blanche", 3, 4);
			color = Color.WHITE;
		}
		
		//Noir
		else if ( (sample[0]*1000<30) && (sample[1]*1000<30) && (sample[2]*1000<30)) {
			LCD.drawString("Ligne noire", 3, 4);
			color = Color.BLACK;
		}
		
		Button.waitForAnyPress();
		capteurCouleur.close();
		
	}
	 public int getColor(){
		 return color;
	 }
		
}
