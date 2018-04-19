import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class A_star {
	
	Graph g = new Graph();
	
	public void  research(Graph g){
		ArrayList<Node> OpenList = new ArrayList<Node>();
		ArrayList<Node> CloseList = new ArrayList<Node>();
		
		Node start = new Node();
		Node end = new Node();
		start = g.get_start();
		end = g.get_end();
		
		OpenList.add(g.get_start());
		
				
		//判断  CloseList 里面是否有  end，若有，则 A 为 Yes，若没有，则 A 为 No
		g.get_start().set_G(0);
		int s;
		s = Math.max(Math.abs(g.get_start().get_X() - g.get_end().get_X()), Math.abs(g.get_start().get_Y() - g.get_end().get_Y()));
		g.get_start().set_H(s);
		g.get_start().set_F(start.get_G() + start.get_H());
		
		while (OpenList.size() != 0) {
			
			//OpenList里面的对象排序
			Comparator<Node> comparator=new Comparator<Node>() {
		        public int compare(Node a, Node b) {
		            if(a.get_F() >= b.get_F()){
		                return 1;
		            }else {
		                return -1;
		            }
		        }
		    };
		    Collections.sort(OpenList,comparator);
			
		    //OpenList里面F值最小的对象给node
			Node node = new Node();
			node = OpenList.get(0);
			
			
			OpenList.remove(node);
			CloseList.add(node);
			node.set_reachable(false);

			//到达end点退出循环
			if(node.get_X() == g.get_end().get_X() && node.get_Y() == g.get_end().get_Y()) {
				
				break;
			}
			
			
			ArrayList<Node> surroundNodes = new ArrayList<Node>(GetSurroundNodes(node, g));
			
			for(int i=0;i<surroundNodes.size();i++) {
				
				surroundNodes.get(i).set_H(CalcH(surroundNodes.get(i), g.get_end()));
				
			    while(OpenList.contains(surroundNodes.get(i)) == false){
					surroundNodes.get(i).set_F(surroundNodes.get(i).get_H() + node.get_G() + CalcG(surroundNodes.get(i), node));
					surroundNodes.get(i).set_parent(node);
					OpenList.add(surroundNodes.get(i));	
				}
			}
		}	
	}
	
	
	public void showresult(Graph g) {
		Node m = new Node();
		m = g.get_end().get_parent(); 
		
		while(m.get_X() != g.get_start().get_X() || m.get_Y() != g.get_start().get_Y()) {
			m.set_value("X");
			m = m.get_parent();
		}
		g.ShowGraph();
	}
	
	
	
	
	//下面两个函数计算G、H
	public double CalcG(Node a, Node b){
		double G;
        G = Math.sqrt( Math.pow(a.get_X()-b.get_X(),2)+Math.pow(a.get_Y()- b.get_Y(), 2)); 
		return G;
	}
	
	
	public double CalcH(Node a, Node b){
		double H;
		H = Math.abs(a.get_X() - b.get_X()) + Math.abs(a.get_Y() - b.get_Y());   
		return H;
	}
    
    //展开点周围的八个点的函数
	public ArrayList<Node> GetSurroundNodes(Node node,Graph g){
		
        Node up = new Node();
        Node down = new Node();
        Node left = new Node();
        Node right = new Node();
        
       
        //list 里面的点是 node 周围的8个点中可以到达的点 
        ArrayList<Node> list = new ArrayList<Node>();    
       
        up = g.get_node((node.get_X() - 1), node.get_Y());
        down = g.get_node((node.get_X() + 1), node.get_Y());
        left = g.get_node(node.get_X(), (node.get_Y() - 1));
        right = g.get_node(node.get_X(), (node.get_Y() + 1));
        
        
        //判断周围八个点是否可到达，可以到达的点加入list，最后返回list
        if(up.get_reachable() == true) {
        	list.add(up);
        }
        if(down.get_reachable() == true) {
        	list.add(down);
        }
        if(left.get_reachable() == true) {
        	list.add(left);
        }
        if(right.get_reachable() == true) {
        	list.add(right);
        }
        
        return list;
	}   
}