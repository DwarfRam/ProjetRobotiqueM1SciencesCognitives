package projet;

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
}
