//package projet;
//
//import lejos.hardware.Button;
//import lejos.robotics.subsumption.Behavior;
//
///**
// * 
// * <b> 
// * Quatrieme objectif : Affichage du chemin optimal pour arriver a la destination
// * </b>
// *
// * <p>
// * Le robot doit afficher le chemin calcule sur l'ecran. 
// * </p>
// * 
// * <p>
// * Cette classe implemente la classe Behavior car correspond a un comportement. 
// * </p>
// */
//public class BestPath implements Behavior{
//	private Robot warrior;
//
//	public BestPath(Robot w) {
//		this.warrior = w;
//	}
//	
//	@Override
//	public boolean takeControl() {
//		return(Button.LEFT.isDown());
//	}
//
//	@Override
//	public void action() {
//		warrior.searchBestPath();
//	}
//
//	@Override
//	public void suppress() {
//	}
//
//}
