public class Node  {
		private double x;
		private double y;
		private boolean reachable;
		private double F;
		private double G;
		private double H;
		private Node parent;
		
		public Node (int x,int y,boolean reachable) {
			this.x = x;
			this.y = y;
			this.reachable = reachable;
		}
		
		public Node(){
			
		}
		
		public Object clone() {  
	        Node n = null;  
	        try{  
	            n = (Node)super.clone();  
	        }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	        }  
	        return n;  
	    }  
		
		public double get_X() {
			return x;
		};
		
		public double get_Y() {
			return y;
		}

		public void set_XY(double x ,double y){
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
}
