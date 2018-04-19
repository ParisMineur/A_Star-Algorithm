public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				A_star a = new A_star();
				Graph g = new Graph();
				a.research(g);
				Draw.drawPointsTest(a.showresult(g));
	}
}
