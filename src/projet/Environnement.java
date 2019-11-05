package projet;

import java.util.ArrayList;

import lejos.robotics.Color;

public class Environnement { 
	
	//private ArrayList<CaseEnvironnement> env = new ArrayList<CaseEnvironnement>();
	private CaseEnvironnement start;
	private CaseEnvironnement caseActuel;
	private CaseEnvironnement [][] carte ;

	
	public Environnement ( CaseEnvironnement s){
		start = s;
		caseActuel = start;
		//carte = c;
		// this.env = new CaseEnvironnement[7][5]; 
	}
	
	public CaseEnvironnement getCase(){
		return caseActuel;
	}
	public void setCase(int c, int cos){
		caseActuel.setColor(c);
		caseActuel.setCost(cos);
	}
	
	public CaseEnvironnement [][] getEnvironnement(){
		return carte;
	}
	
	
}
