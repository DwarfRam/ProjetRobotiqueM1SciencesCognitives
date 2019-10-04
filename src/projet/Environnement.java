package projet;

import java.util.ArrayList;

import lejos.robotics.Color;

public class Environnement { 
	
	private ArrayList<CaseEnvironnement> env = new ArrayList<CaseEnvironnement>();
	private CaseEnvironnement start;
	private CaseEnvironnement caseActuel;
	
	public Environnement (ArrayList<CaseEnvironnement> map, CaseEnvironnement s){
		start = s;
		caseActuel = start;
		env = map;
		// this.env = new CaseEnvironnement[7][5]; 
		
		//private int color;
		private int carte [][];

		public void carte(boolean t){	
			carte = new int [6][4];	
			if (t == true) //Winterfell
			{
				carte [0][0]= Color.RED; //Camp militaire nord ouest 
				carte [0][1]= Color.BLUE;
				carte [1][0]= Color.GREEN;
				carte [1][1]= Color.BLUE;
				carte [2][0]= Color.GREEN;
				carte [2][1]= Color.BLUE;
				carte [2][2]= Color.BLUE;
				carte [3][0]= Color.GREEN;
				carte [3][1]= Color.GREEN;
				carte [3][2]= Color.BLUE;
				carte [4][0]= Color.GREEN;
				carte [4][1]= Color.ORANGE;
				carte [4][2]= Color.ORANGE;
				carte [4][3]= Color.ORANGE;
				carte [5][0]= Color.GREEN;
				carte [5][1]= Color.GREEN;
				carte [5][2]= Color.GREEN;
				carte [5][3]= Color.RED; //camp militaire sud
				carte [5][4]= Color.BLUE;
				carte [6][0]= Color.WHITE; //Départ Winterfell
				carte [6][1]= Color.GREEN;
				carte [6][2]= Color.GREEN;
				carte [6][3]= Color.GREEN;
				carte [6][5]= Color.BLUE;
			}
			else if (t == false) //Thenn
			{ 
				carte [0][0]= Color.RED; // Camp militaire nord ouest 
				carte [0][1]= Color.BLUE;
				carte [0][2]= Color.GREEN;
				carte [0][3]= Color.GREEN;
				carte [0][4]= Color.WHITE; // Départ Thenn
				carte [1][1]= Color.BLUE;
				carte [1][2]= Color.GREEN;
				carte [1][3]= Color.GREEN;
				carte [1][4]= Color.GREEN;
				carte [2][1]= Color.BLUE;
				carte [2][2]= Color.BLUE;
				carte [2][3]= Color.GREEN;
				carte [2][4]= Color.ORANGE;
				carte [3][2]= Color.BLUE;
				carte [3][3]= Color.GREEN;
				carte [3][4]= Color.GREEN;
				carte [4][3]= Color.ORANGE;
				carte [4][4]= Color.GREEN;
				carte [5][3]= Color.RED; // Camp militaire sud
				carte [5][4]= Color.BLUE;
				carte [6][4]= Color.BLUE;
			}
		}

		//Getter
		public int getColorCase(int abs, int ord){
			return carte [abs][ord];
		}
		
		//Setter
		public void setColorCase(int abs, int ord, int color){
			this.carte[abs][ord]= color;
		}

	}
	public CaseEnvironnement getCase(){
		return caseActuel;
	}
	public void setCase(int c, int cos){
		caseActuel.setColor(c);
		caseActuel.setCost(cos);
	}
}
