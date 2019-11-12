package projet;

public class Robot {

	private String nom;	
	private boolean team; 
	private CaseEnvironnement [][] environnement;
	
	public Robot (String n, boolean t){
		this.nom = n;
		this.team = t;
		this.environnement = new CaseEnvironnement [5][7];
	}
	
	public boolean getTeam(){
		return team;
	}
	
	public void setTeam(boolean newTeam){
		this.team= newTeam;
	}
	
	public String getNom(){
		return nom;
	}
	
	// test
	public String getStart(){
		if (this.team == true) 
		{
			return(this.environnement[0][0].getCase());
		}
		else if (this.team == false)
		{
			return(this.environnement[4][6].getCase());	
		}
		return ("error");
	}
	
	public void setEnvironnement(int abs, int ord, int col) {
		this.environnement[abs][ord] = new CaseEnvironnement(col,abs,ord);
	}
	
	public void CreationMap(
			
			) {
		// RED = 0, GREEN=1, BLUE = 2, ORANGE=5, WHITE=6, BLACK=7	
		if (this.team == true) //Garde de nuit
		{
			this.environnement[0][0] = new CaseEnvironnement(6,0,0);	//départ au sud ouest
			this.environnement[1][0] = new CaseEnvironnement(1,1,0);
			this.environnement[2][0] = new CaseEnvironnement(1,2,0);
			this.environnement[3][0] = new CaseEnvironnement(1,3,0);
			this.environnement[4][0] = new CaseEnvironnement(2,4,0);
			this.environnement[0][1] = new CaseEnvironnement(1,0,1);
			this.environnement[1][1] = new CaseEnvironnement(1,1,1);
			this.environnement[2][1] = new CaseEnvironnement(1,2,1);
			this.environnement[3][1] = new CaseEnvironnement(0,3,1);	// camp militaire au sud est
			this.environnement[4][1] = new CaseEnvironnement(2,4,1);

			this.environnement[0][2] = new CaseEnvironnement(1,0,2);
			this.environnement[1][2] = new CaseEnvironnement(5,1,2);
			this.environnement[2][2] = new CaseEnvironnement(5,2,2);
			this.environnement[3][2] = new CaseEnvironnement(5,3,2);

			this.environnement[0][3] = new CaseEnvironnement(1,0,3);
			this.environnement[1][3] = new CaseEnvironnement(1,1,3);
			this.environnement[2][3] = new CaseEnvironnement(2,2,3);
			
			this.environnement[0][4] = new CaseEnvironnement(1,0,4);
			this.environnement[1][4] = new CaseEnvironnement(2,1,4);
			this.environnement[2][4] = new CaseEnvironnement(2,2,4);

			this.environnement[0][5] = new CaseEnvironnement(1,1,5);
			this.environnement[1][5] = new CaseEnvironnement(2,1,5);
			
			this.environnement[0][6] = new CaseEnvironnement(0,0,6);	// camp militaire au nord ouest
			this.environnement[1][6] = new CaseEnvironnement(2,1,6);
		}
		else //Sauvageon
		{ 
			this.environnement[4][0] = new CaseEnvironnement(2,4,0);
			
			this.environnement[3][1] = new CaseEnvironnement(0,3,1);	// camp militaire au sud est
			this.environnement[4][1] = new CaseEnvironnement(2,4,1);
			
			this.environnement[3][2] = new CaseEnvironnement(5,3,2);
			this.environnement[4][2] = new CaseEnvironnement(1,4,2);
			
			this.environnement[2][3] = new CaseEnvironnement(2,2,3);
			this.environnement[3][3] = new CaseEnvironnement(1,3,3);
			this.environnement[4][3] = new CaseEnvironnement(1,4,3);
			
			this.environnement[1][4] = new CaseEnvironnement(2,1,4);			
			this.environnement[2][4] = new CaseEnvironnement(2,2,4);
			this.environnement[3][4] = new CaseEnvironnement(1,3,4);
			this.environnement[4][4] = new CaseEnvironnement(5,4,4);
			
			this.environnement[1][5] = new CaseEnvironnement(1,1,5);			
			this.environnement[2][5] = new CaseEnvironnement(1,2,5);
			this.environnement[3][5] = new CaseEnvironnement(1,3,5);
			this.environnement[4][5] = new CaseEnvironnement(2,4,5);
			
			this.environnement[0][6] = new CaseEnvironnement(0,0,6);	// camp militaire au nord ouest
			this.environnement[1][6] = new CaseEnvironnement(2,1,6);			
			this.environnement[2][6] = new CaseEnvironnement(1,2,6);
			this.environnement[3][6] = new CaseEnvironnement(1,3,6);
			this.environnement[4][6] = new CaseEnvironnement(6,4,6); 	// départ au nord est
		}
	}
}
