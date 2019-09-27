package projet;

public class CaseEnvironnement {
	
	private int color;
	private int size;
	private int cost;
	
	public CaseEnvironnement(int col, int dim, int cout){
		this.color = col;
		this.size = dim;
		this.cost = cout;
	}
	
	public void setColor(int c){
		color = c;
	}
		
}
