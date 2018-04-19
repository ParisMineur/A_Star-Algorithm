import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class A_star {
	
	public void  research(Graph g){
		ArrayList<Node> OpenList = new ArrayList<Node>();
		ArrayList<Node> CloseList = new ArrayList<Node>();

		OpenList.add(g.get_start());
		
		g.get_start().set_G(0);
		g.get_start().set_H(35.35);
		g.get_start().set_F(g.get_start().get_G() + g.get_start().get_H());
		
		
		while (OpenList.size() != 0) {
			
			//OpenList里面的对象排序
			Comparator<Node> comparator=new Comparator<Node>() {
		        public int compare(Node a, Node b) {
		            if(a.get_F() >= b.get_F()){
		                return 1;
		            }
		            else 
		            {
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
			if( g.get_end().get_X() - node.get_X()<1 && g.get_end().get_Y() - node.get_Y() <1) {
				g.get_end().set_parent(node);
				break;
			}
			
			
			ArrayList<Node> surroundNodes = new ArrayList<Node>(GetSurroundNodes(node));
			
			
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
	
	
	//将最终路径节点返回Finallist
	public ArrayList<Node>  showresult(Graph g) {
		ArrayList<Node> Finallist=new ArrayList<Node>();
		Finallist.add(g.get_end());
		
		Node m = new Node();
		m = g.get_end().get_parent();

		while(m.get_X() != g.get_start().get_X() && m.get_Y() != g.get_start().get_Y()) {
			m = m.get_parent();
			Finallist.add(m);
		}
		
		return Finallist;
	}
	
	
	//下面两个函数计算G、H
	public double CalcG(Node a, Node b){
		double G;
        G = Math.sqrt( Math.pow(a.get_X()-b.get_X(),2)+Math.pow(a.get_Y()- b.get_Y(), 2)); 
		return G;
	}
	
	
	public double CalcH(Node a, Node b){
		double H;
		H =Math.sqrt(Math.pow(a.get_X() - b.get_X(),2)+ Math.pow(a.get_Y() - b.get_Y(),2));   
		return H;
	}
    
	
    //展开点周围的5个点的函数
	public ArrayList<Node> GetSurroundNodes(Node node){
		
        Node N1 = new Node();
        Node N2 = new Node();
        Node N3 = new Node();
        Node N4 = new Node();
        Node N5 = new Node();

        
        //list 里面的点是 node 周围的5个点中可以到达的点 
        ArrayList<Node> list = new ArrayList<Node>();    
        double d=1;
        double pi=3.14;
        
        //先给周围5个点赋值
        N1.set_XY(node.get_X()+d*Math.cos(2*pi/9), node.get_Y()+d*Math.sin(2*pi/9));
        N2.set_XY(node.get_X()+d*Math.cos(pi/9), node.get_Y()+d*Math.sin(pi/9));
        N3.set_XY(node.get_X()+d, node.get_Y());
        N4.set_XY(node.get_X()+d*Math.cos(pi/9), node.get_Y()-d*Math.sin(pi/9));
        N5.set_XY(node.get_X()+d*Math.cos(2*pi/9), node.get_Y()-d*Math.sin(2*pi/9));


        
        //判断周围5个点是否可到达，可以到达的点加入list，最后返回list
        if(Math.sqrt(Math.pow(N1.get_X()-25,2)+Math.pow(N1.get_Y()-25, 2))>10&&N1.get_X()<50&&N1.get_X()>0&&N1.get_Y()<50&&N1.get_Y()>0) {
        	list.add(N1);
        }
        if(Math.sqrt(Math.pow(N2.get_X()-25,2)+Math.pow(N2.get_Y()-25, 2))>10&&N2.get_X()<50&&N2.get_X()>0&&N2.get_Y()<50&&N2.get_Y()>0) {
        	list.add(N2);
        }
        if(Math.sqrt(Math.pow(N3.get_X()-25,2)+Math.pow(N3.get_Y()-25, 2))>10&&N3.get_X()<50&&N3.get_X()>0&&N3.get_Y()<50&&N1.get_Y()>0) {
        	list.add(N3);
        }
        if(Math.sqrt(Math.pow(N4.get_X()-25,2)+Math.pow(N4.get_Y()-25, 2))>10&&N4.get_X()<50&&N4.get_X()>0&&N4.get_Y()<50&&N4.get_Y()>0) {
        	list.add(N4);
        }
        if(Math.sqrt(Math.pow(N5.get_X()-25,2)+Math.pow(N5.get_Y()-25, 2))>10&&N5.get_X()<50&&N5.get_X()>0&&N5.get_Y()<50&&N5.get_Y()>0){
        	list.add(N5);
        }
 
        return list;
	}   
}