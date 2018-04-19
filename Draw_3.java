import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;


public class Draw {
	
	public static void drawPointsTest(ArrayList<Node> List){
		
	    Color red = new Color(255, 0, 0);
		Color black = new Color(0, 0, 0);
		
		
		//save the points in terms of arrays
		double[] sNode = {10, 15};
		double[] eNode = {40, 25};
		
		
		//障碍物位置
		double[] node1 = {25,35};
		double[] node2 = {25 + 5*Math.sqrt(2),25 + 5*Math.sqrt(2)};
		double[] node3 = {35,25};
		double[] node4 = {25 + 5*Math.sqrt(2),25 - 5*Math.sqrt(2)};
		double[] node5 = {25,15};
		double[] node6 = {25 - 5*Math.sqrt(2),25 - 5*Math.sqrt(2)};
		double[] node7 = {15,25};
		double[] node8 = {25 - 5*Math.sqrt(2),25 + 5*Math.sqrt(2)};
		
		
		//create a plot panel
		Plot2DPanel plot = new Plot2DPanel();
		plot.addScatterPlot("my plot", black, sNode, eNode);
		
		
		//画出障碍物
		plot.addLinePlot(null, red, node1, node2);
		plot.addLinePlot(null, red, node2, node3);
		plot.addLinePlot(null, red, node3, node4);
		plot.addLinePlot(null, red, node4, node5);
		plot.addLinePlot(null, red, node5, node6);
		plot.addLinePlot(null, red, node6, node7);
		plot.addLinePlot(null, red, node7, node8);
		plot.addLinePlot(null, red, node8, node1);
		
		
		//画出最后的曲线
		for(int i=0;i<List.size()-1;i++) {
			double[] nodea= {List.get(i).get_X(),List.get(i).get_Y()};
			double[] nodeb= {List.get(i+1).get_X(),List.get(i+1).get_Y()};
			plot.addLinePlot(null, black, nodea, nodeb);
		}
		
		
		//set the label of the plot panel
	    plot.setAxisLabel(0, "X (km)");
	    plot.setAxisLabel(1, "Y (km)");
	    
	    
	    //set the boundary of the plot panel
	    double boundMin1[]  = {0, 0};
	    double boundMax1[]  = {50, 50};
	    plot.setFixedBounds(boundMin1, boundMax1);	
	    
	    
	    //create a frame
	    JFrame frame = new JFrame("A plot test");
	    
	    
	    //set the size of the frame
	    frame.setSize(600, 600);
	    
	    
	    //set the content of the frame as the plot panel
	    frame.setContentPane(plot);
	    frame.setVisible(true);
	}
}
