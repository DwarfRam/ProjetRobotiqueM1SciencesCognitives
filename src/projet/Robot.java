package projet;

import lejos.robotics.Color;

public class Robot {

	private String nom;	
	private boolean team; 
	private Environnement env;
	
	public Robot (String n, boolean t, Environnement e){
		this.nom=n; this.team=t; this.env=e;
	}
	
	//Getter
	public boolean getTeam(){
		return team;
	}
	
	//Setter
	public void setTeam(boolean newTeam){
		this.team= newTeam;
	}
	
	public void CreationMap() {
		CaseEnvironnement [][] carte ;
		carte = env.getEnvironnement();
		if (team == true) //Winterfell
		{
			carte [0][0]= new CaseEnvironnement(Color.RED); //Camp militaire nord ouest 
			carte [0][1]= new CaseEnvironnement(Color.BLUE);
			carte [1][0]= new CaseEnvironnement(Color.GREEN);
			carte [1][1]= new CaseEnvironnement(Color.BLUE);
			carte [2][0]= new CaseEnvironnement(Color.GREEN);
			carte [2][1]= new CaseEnvironnement(Color.BLUE);
			carte [2][2]= new CaseEnvironnement(Color.BLUE);
			carte [3][0]= new CaseEnvironnement(Color.GREEN);
			carte [3][1]= new CaseEnvironnement(Color.GREEN);
			carte [3][2]= new CaseEnvironnement(Color.BLUE);
			carte [4][0]= new CaseEnvironnement(Color.GREEN);
			carte [4][1]= new CaseEnvironnement(Color.ORANGE);
			carte [4][2]= new CaseEnvironnement(Color.ORANGE);
			carte [4][3]= new CaseEnvironnement(Color.ORANGE);
			carte [5][0]= new CaseEnvironnement(Color.GREEN);
			carte [5][1]= new CaseEnvironnement(Color.GREEN);
			carte [5][2]= new CaseEnvironnement(Color.GREEN);
			carte [5][3]= new CaseEnvironnement(Color.RED); //camp militaire sud
			carte [5][4]= new CaseEnvironnement(Color.BLUE);
			carte [6][0]= new CaseEnvironnement(Color.WHITE); //Départ Winterfell
			carte [6][1]= new CaseEnvironnement(Color.GREEN);
			carte [6][2]= new CaseEnvironnement(Color.GREEN);
			carte [6][3]= new CaseEnvironnement(Color.GREEN);
			carte [6][5]= new CaseEnvironnement(Color.BLUE);
		}
		else //Thenn
		{ 
			carte [0][0]= new CaseEnvironnement(Color.RED); // Camp militaire nord ouest 
			carte [0][1]= new CaseEnvironnement(Color.BLUE);
			carte [0][2]= new CaseEnvironnement(Color.GREEN);
			carte [0][3]= new CaseEnvironnement(Color.GREEN);
			carte [0][4]= new CaseEnvironnement(Color.WHITE); // Départ Thenn
			carte [1][1]= new CaseEnvironnement(Color.BLUE);
			carte [1][2]= new CaseEnvironnement(Color.GREEN);
			carte [1][3]= new CaseEnvironnement(Color.GREEN);
			carte [1][4]= new CaseEnvironnement(Color.GREEN);
			carte [2][1]= new CaseEnvironnement(Color.BLUE);
			carte [2][2]= new CaseEnvironnement(Color.BLUE);
			carte [2][3]= new CaseEnvironnement(Color.GREEN);
			carte [2][4]= new CaseEnvironnement(Color.ORANGE);
			carte [3][2]= new CaseEnvironnement(Color.BLUE);
			carte [3][3]= new CaseEnvironnement(Color.GREEN);
			carte [3][4]= new CaseEnvironnement(Color.GREEN);
			carte [4][3]= new CaseEnvironnement(Color.ORANGE);
			carte [4][4]= new CaseEnvironnement(Color.GREEN);
			carte [5][3]= new CaseEnvironnement(Color.RED); // Camp militaire sud
			carte [5][4]= new CaseEnvironnement(Color.BLUE);
			carte [6][4]= new CaseEnvironnement(Color.BLUE);
		}
}

}
