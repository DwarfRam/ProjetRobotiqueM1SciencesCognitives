package projet;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;

/**
 * <b>
 * Classe permettant de définir l'environnement du robot (différentes cases de la carte)
 * </b>
 * 
 * <p>
 * Cette classe permet de paramétrer divers éléments correspondant aux différentes cases de la carte. 
 * Ces dernières sont définis par leur couleur, qui correspond à leur coût pour le robot, 
 * leur abscisse, et leur ordonnée. 
 * On indique également la taille des cases. 
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
	 * Permet de définir la couleur et les coordonnées des cases. 
	 * Définit également le coût en fonction de la couleur (switch case)
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
	 * Définit la couleur de la case considérée. 
	 * 
	 * @param c : couleur de la case
	 */
	public void setColor(int c){
		color = c;
	}
	
	/**
	 * Définit le coût de la case considérée. 
	 * 
	 * @param cost : coût de la case
	 */
	public void setCost (int cost){
		this.cost = cost;
	}
	
	/**
	 * Retourne les coordonnées de la case considérée. 
	 * 
	 * @return  Les coordonées de la case. 
	 */
	public String getCase(){
		return(Integer.toString(this.abs)+";"+Integer.toString(this.ord));
	}
		
	/**
	 * Retourne la couleur de la case considérée.
	 * 
	 * @return La couleur de la case. 
	 */
	public int getColor(){
		 return color;
	 }
	
	/**
	 * Retourne l'abscisse de la case considérée. 
	 * 
	 * @return L'abscisse de la case. 
	 */
		
	public int getAbs(){
		return abs;
	}
	
	
	/**
	 * Retourne l'ordonnée de la case considérée. 
	 * 
	 * @return L'ordonnée de la case. 
	 */
	public int getOrd () {
		return ord;
	}
}
