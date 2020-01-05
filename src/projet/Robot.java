package projet;

import java.util.List;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

/**
 * <b>
 * La classe Robot correspond � la classe permettant l'initialisation des robots. 
 * </b>
 * 
 * <p>
 * Elle permet de d�finir le nom de l'�quipe du robot. 
 * D'autre part, elle comporte la m�thode permettant l'apprentissage de la carte par le robot.
 * </p>
 *
 */

public class Robot {

	private String nom;	
	private boolean team; 
	private CaseEnvironnement [][] environnement;
	
	/**
	 * 
	 * @param n = Nom de l'�quipe (Garde ou Sauvageon) 
	 * @param t = Booleen permettant de diff�rencier l'�quipe ; (false = sauvageon, true = garde)
	 */
	
	public Robot (String n, boolean t){
		this.nom = n;
		this.team = t;
		this.environnement = new CaseEnvironnement [5][7];
	}
	
	/**
	 * Retourne l'�quipe � laquelle appartient le robot. 
	 * 
	 * @return L'�quipe du robot. 
	 */
	
	public boolean getTeam(){
		return team;
	}
	
	/**
	 * Permet de r�cup�rer la case sur laquelle se trouve le robot.
	 * 
	 * @see CaseEnvironnement (Classe)
	 * 
	 * @return La case sur laquelle est plac� le robot (abscisse et ordonn�e)
	 */
	
	public CaseEnvironnement[][] getEnv(){
		return environnement;
	}
	
	/**
	 * Permet de d�finir l'�quipe
	 * @param newTeam = Team � laquelle doit appartenir le robot. 
	 */
	public void setTeam(boolean newTeam){
		this.team= newTeam;
	}
	
	/**
	 * Retourne le nom de l'�quipe � laquelle le robot appartient.
	 * @return Le nom de l'�quipe. 
	 */
	public String getNom(){
		return nom;
	}
	
	// test - � supprimer ? 
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
	
	/**
	 * M�thode permettant de d�finir la case sur laquelle se trouve le robot, selon son abscisse, son ordonn�e
	 * et sa couleur. 
	 * 
	 * @param abs Abscisse de la case 
	 * @param ord Ordonn�e de la case 
	 * @param col Couleur de la case 
	 */
	public void setEnvironnement(int abs, int ord, int col) {
		this.environnement[abs][ord] = new CaseEnvironnement(col,abs,ord);
	}
	
	/**
	 * M�thode permettant � chaque robot, selon son �quipe, � conna�tre la moiti� de la carte qui lui correspond. 
	 * 
	 * @see CaseEnvironnement (Classe)
	 */
	public void CreationMap() {
		// RED = 0, GREEN=1, BLUE = 2, ORANGE=5, WHITE=6, BLACK=7	
		if (this.team == true) //Garde de nuit
		{
			this.environnement[0][0] = new CaseEnvironnement(6,0,0);	//Depart au sud ouest
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
	
	public void searchBestPath() {
		// -1 = blocked
        // 0+ = additional movement cost
        int[][] maze = {
            {1, 10, 1, 1, 1},
            {1, 10, 1, 1, 1},
            {1, 10, 10, 1, 5},
            {1, 1, 10, 1, 1},
            {1, 5, 5, 5, 1},
            {1, 1, 1, 1, 10},
            {1, 1, 1, 1, 10},
        };
        List<Node> path ;
        if (team == true) {
        	AStar as = new AStar(maze, 4, 0);
        	path = as.findPathTo(0, 6);
        }
        else {
        	AStar as = new AStar(maze, 0, 6);
        	path = as.findPathTo(4, 0);
        }
        LCD.clear();
		if (path != null) {
			
			LCD.drawString("Le chemin sera",0,0);
			LCD.drawString("afficher apres un",0,1);
			LCD.drawString("appui bouton",0,2);
	        LCD.asyncRefresh();
	        Button.waitForAnyPress();
	        
	        int coordoY = 0;						// variable servant a indiquer la coordonnée en x 
            int elem =0;
            for (int i = 1; i < path.size();i++) {
            	String coordoAfficher = "";
            	coordoY += 1;
            	for (int l =0;l<3;l++) {			// on affiche les coordonées par groupe de 3 pour ne pas dépasser sur l'écran
            		Node n = path.get(elem);		// on cherche le node suivant retournée dans la liste retourné par la recherche de chemin
            		coordoAfficher = coordoAfficher.concat("[" + n.x + "," + n.y + "]");
            		if ((elem+1)< path.size()) {
                		elem += 1;
            		}
            		else {
            			break;
            		}
            	}
        		LCD.drawString(coordoAfficher,0,coordoY);
            	if ((path.get(path.size()-1)) == path.get(elem)) {	// si l'element qui est cours correspond au dernier élément de la liste on sort de la boucle
            		break;
            	}
	        }
	        LCD.asyncRefresh();
        	Button.waitForAnyPress();
        }
	}
}
