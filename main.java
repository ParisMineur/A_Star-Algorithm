public class main {
	public static void main(String[] args) {
		
		A_star a = new A_star();
		Graph g = new Graph();
		
		a.g.ShowGraph();
		
		System.out.println(" ");
		System.out.println(" ");
		
		a.research(g);
		a.showresult(g);
		
	}
}
