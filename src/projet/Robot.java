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
		/*Environnement [][] carte ;
		carte = new Environnement();*/
		
		// RED = 0, GREEN=1, BLUE = 2, ORANGE=5, WHITE=6, BLACK=7	
		if (team == true) //Winterfell
		{
			this.env.setCase(0, 0, 0); //Camp militaire nord ouest 
			this.env.setCase(2, 0, 1);
			this.env.setCase(1, 1, 0);	
			this.env.setCase(2, 1, 1);
			this.env.setCase(1, 2, 0);
			this.env.setCase(2, 2, 1);
			this.env.setCase(2, 2, 2);
			this.env.setCase(1, 3, 0);
			this.env.setCase(1, 3, 1);
			this.env.setCase(2, 3, 2);
			this.env.setCase(1, 4, 0);
			this.env.setCase(5, 4, 1);
			this.env.setCase(5, 4, 2);
			this.env.setCase(5, 4, 3);
			this.env.setCase(1, 5, 0);
			this.env.setCase(1, 5, 1);
			this.env.setCase(1, 5, 2);
			this.env.setCase(0, 5, 3); //camp militaire sud
			this.env.setCase(2, 5, 4); 
			this.env.setCase(6, 6, 0); //Départ Winterfell
			this.env.setCase(1, 6, 1); 
			this.env.setCase(1, 6, 2);
			this.env.setCase(1, 6, 3);
			this.env.setCase(2, 6, 4);
			
		}
		else //Thenn
		{ 
			this.env.setCase(0, 0, 0);
			this.env.setCase(2, 0, 1); // Camp militaire nord ouest 
			this.env.setCase(1, 0, 2);
			this.env.setCase(1, 0, 3);
			this.env.setCase(6, 0, 4); // Départ Thenn
			this.env.setCase(2, 1, 1); 
			this.env.setCase(1, 1, 2);
			this.env.setCase(1, 1, 3);
			this.env.setCase(1, 1, 4);
			this.env.setCase(2, 2, 1);
			this.env.setCase(2, 2, 2);
			this.env.setCase(1, 2, 3);
			this.env.setCase(5, 2, 4);
			this.env.setCase(2, 3, 2);
			this.env.setCase(1, 3, 3);
			this.env.setCase(1, 3, 4);
			this.env.setCase(5, 4, 3);
			this.env.setCase(1, 4, 4);
			this.env.setCase(0, 5, 3); // Camp militaire sud
			this.env.setCase(2, 5, 4);
			this.env.setCase(2, 6, 4);
		}
}

}
