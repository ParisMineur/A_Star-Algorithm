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
		
				
		//�ж�  CloseList �����Ƿ���  end�����У��� A Ϊ Yes����û�У��� A Ϊ No
		g.get_start().set_G(0);
		int s;
		s = Math.max(Math.abs(g.get_start().get_X() - g.get_end().get_X()), Math.abs(g.get_start().get_Y() - g.get_end().get_Y()));
		g.get_start().set_H(s);
		g.get_start().set_F(start.get_G() + start.get_H());
		
		while (OpenList.size() != 0) {
			
			//OpenList����Ķ�������
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
			
		    //OpenList����Fֵ��С�Ķ����node
			Node node = new Node();
			node = OpenList.get(0);
			
			
			OpenList.remove(node);
			CloseList.add(node);
			node.set_reachable(false);

			//����end���˳�ѭ��
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
	
	
	
	
	//����������������G��H
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
    
    //չ������Χ�İ˸���ĺ���
	public ArrayList<Node> GetSurroundNodes(Node node,Graph g){
		
        Node up = new Node();
        Node down = new Node();
        Node left = new Node();
        Node right = new Node();
        
       
        //list ����ĵ��� node ��Χ��8�����п��Ե���ĵ� 
        ArrayList<Node> list = new ArrayList<Node>();    
       
        up = g.get_node((node.get_X() - 1), node.get_Y());
        down = g.get_node((node.get_X() + 1), node.get_Y());
        left = g.get_node(node.get_X(), (node.get_Y() - 1));
        right = g.get_node(node.get_X(), (node.get_Y() + 1));
        
        
        //�ж���Χ�˸����Ƿ�ɵ�����Ե���ĵ����list����󷵻�list
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