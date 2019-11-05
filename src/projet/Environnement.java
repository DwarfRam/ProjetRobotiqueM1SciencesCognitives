package projet;

import java.util.ArrayList;

import lejos.robotics.Color;

public class Environnement { 
	
	private CaseEnvironnement start;
	private CaseEnvironnement caseActuel;
	private ArrayList<CaseEnvironnement> map;
	
	public Environnement (ArrayList<CaseEnvironnement> environnement, CaseEnvironnement s){
		start = s;
		caseActuel = start;
		map = environnement;
	}
	
	public CaseEnvironnement getCase(){
		return caseActuel;
	}
	public void setCase(int c, int cos){
		caseActuel.setColor(c);
		caseActuel.setCost(cos);
	}
	
	public ArrayList<CaseEnvironnement> getEnvironnement(){
		return map;
	}
	
	
}
