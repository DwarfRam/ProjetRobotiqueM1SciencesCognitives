package projet;

import lejos.robotics.Color;

public class Environnement { 
	
	private CaseEnvironnement start;
	private CaseEnvironnement caseActuel;
	private CaseEnvironnement [][] environnement ;
	
	public Environnement (CaseEnvironnement [][] map, CaseEnvironnement s){
		this.start = s;
		this.caseActuel = start;
		this.environnement = map; 
	}
	
	public CaseEnvironnement getActualCase(){
		return caseActuel;
	}
	
	// setter pour la modification de case de l'environnement via l'ordonnée et l'abscisse
	public void setCase(int c, int abs, int ord){
		environnement[abs][ord].setColor(c);
	}
	
	// setter pour l'apprentissage de la carte par le robot 
	public void setCase(int c){
		caseActuel.setColor(c);
	}
	
	public CaseEnvironnement [][] getEnvironnement(){
		return environnement;
	}
	
	
}
