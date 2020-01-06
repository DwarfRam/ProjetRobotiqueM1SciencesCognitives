package projet;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;

/**
 * <b>
 * Classe permettant de definir l'environnement du robot (differentes cases de la carte).
 * </b>
 * 
 * <p>
 * Cette classe permet de parametrer divers elements correspondant aux differentes cases de la carte. 
 * Ces dernieres sont definies par leur couleur, qui correspond a leur cout pour le robot, 
 * leur abscisse, et leur ordonnee. 
 * On indique egalement la taille des cases. 
 * </p>
 * 
 *
 */

public class CaseEnvironnement {
	
	private int color;
	private int SIZE;
	private int cost;
	private int abs;
	private int ord;
	
	/**
	 * Permet de definir la couleur et les coordonnees des cases. 
	 * Definit egalement le cout en fonction de la couleur (switch case)
	 * 
	 * @param col Couleur de la case
	 * @param x Abscisse de la case
	 * @param y Ordonnée de la case 
	 * 
	 * 
	 */
	
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
	
	/**
	 * Definit la couleur de la case consideree. 
	 * 
	 * @param c : couleur de la case
	 */
	public void setColor(int c){
		color = c;
	}
	
	/**
	 * Definit le coût de la case consideree. 
	 * 
	 * @param cost : cout de la case
	 */
	public void setCost (int cost){
		this.cost = cost;
	}
	
	/**
	 * Retourne les coordonnees de la case consideree. 
	 * 
	 * @return  Les coordonees de la case. 
	 */
	public String getCase(){
		return(Integer.toString(this.abs)+";"+Integer.toString(this.ord));
	}
		
	/**
	 * Retourne la couleur de la case consideree.
	 * 
	 * @return La couleur de la case. 
	 */
	public int getColor(){
		 return color;
	 }
	
	/**
	 * Retourne l'abscisse de la case considere. 
	 * 
	 * @return L'abscisse de la case. 
	 */
		
	public int getAbs(){
		return abs;
	}
	
	
	/**
	 * Retourne l'ordonnée de la case consideree. 
	 * 
	 * @return L'ordonnee de la case. 
	 */
	public int getOrd () {
		return ord;
	}
}
