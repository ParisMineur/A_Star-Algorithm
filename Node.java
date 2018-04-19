public class Node {
	private int x;
	private int y;
	private boolean reachable;
	private double F;
	private double G;
	private double H;
	private Node parent;
	private String value;
	
	public Node (int x,int y,String value,boolean reachable) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.reachable = reachable;
	}
	
	public Node(){
		
	}
	
	
	public int get_X() {
		return x;
	};
	
	public int get_Y() {
		return y;
	}

	public void set_XY(int x ,int y){
		this.x = x;
		this.y = y;
	} 
	
	public boolean get_reachable() {
		return reachable;
	}
	
	public void set_reachable(boolean s) {
		reachable = s;
	}
	
	public double get_F() {
		return F;
	}
	
	public double get_G() {
		return G;
	}
	
	public double get_H() {
		return H;
	}
	
	public void set_F(double f) {
		F = f;
	}
	
	public void set_G(double g) {
		G = g;
	}
	
	public void set_H(double h) {
		H = h;
	}

	public Node get_parent() {
		return parent;
	}

	public void set_parent(Node parent) {
		this.parent = parent;
	}
	
	public String get_value() {
		return value;
	}
	
	public void set_value(String value) {
		this.value = value;
	}
}