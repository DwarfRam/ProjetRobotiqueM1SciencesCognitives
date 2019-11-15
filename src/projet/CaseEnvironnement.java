package projet;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;

public class CaseEnvironnement {
	
	private int color;
	private int SIZE;
	private int cost;
	private int abs;
	private int ord;
	
	public CaseEnvironnement(int col, int x, int y){
		this.color = col;
		this.SIZE = 12;
		this.abs = x;
		this.ord = y;
		
		switch(col) {
		  case 0: // red
			  this.cost = 1;
			  break;
		  case 1 : // green
			 this.cost = 1;
			 break;
		  case 5 : // orange
		    this.cost = 5;
		    break;
		  case 2 : // blue
		    this.cost = 10;
		    break;
		  case 7:  // black
		    this.cost = 12;
		    break;
		  case 6: // white
		    this.cost = 1;
		    break;
		  default:
			  this.cost = 0;
			  break;
		}
	}
	
	public void setColor(int c){
		color = c;
	}
	
	public void setCost (int cost){
		this.cost = cost;
	}
	
	public String getCase(){
		return(Integer.toString(this.abs)+";"+Integer.toString(this.ord));
	}
		
	public int getColor(){
		 return color;
	 }
		
}
