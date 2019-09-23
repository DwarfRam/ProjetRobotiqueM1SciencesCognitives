package colorCalibration;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

/**
 * Class for the calibration of color
 * 
 * @version 1.0
 *
 * @author Christian B.
 */
public class CouleurRGB {
	public static void main(String[] args) {
		LCD.drawString("Calibration of color",0,0);
        LCD.asyncRefresh();
		Button.waitForAnyPress();
		
		EV3ColorSensor capteurCouleur;
		capteurCouleur = new EV3ColorSensor(SensorPort.S3);
		float[] tab = new float[3];
		capteurCouleur.getRGBMode().fetchSample(tab, 0);
		for (int i = 0; i <=2; i++) {
			float color = tab[i]*1000;
			System.out.println((int)color);
		}
		capteurCouleur.close();
		Button.waitForAnyPress();
	}
}
