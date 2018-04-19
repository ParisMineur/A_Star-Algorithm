import java.util.ArrayList;

public class Graph {
	private Node[][] graph;
	private Node start;
	private Node end;
	
	ArrayList<Node> Obstacle = new ArrayList<Node>();   //�ϰ���ڵ��List
	
	public Node[][] get_Graph() {
		return graph;
	}
	
	public void set_Graph(Node[][] graph) {
		this.graph = graph;
	}
	
	public Node get_node(int a, int b) {
		return graph[a][b];
	}
	
	
	public Node get_start() {
		return start;
	}
	
	public Node get_end() {
		return end;
	}
	
	
	public void set_start_end(Node start,Node end) {
		this.start = start;
		this.end = end;
	}
	
	
	//���õ�ͼ������start��end���ϰ��ڵ�
	public Graph(){
		graph = new Node[50][50];
		
		int x, y;
		for(x=0;x<graph.length;x++) {
			for(y=0;y<graph[0].length;y++) {
				graph[x][y] = new Node(x,y,true);
			}
		}
		
		
		//��ʼ��start��end��λ�úͱ��
		start = graph[10][15];
		end = graph[40][25];
		start.set_reachable(false);
		end.set_reachable(true);
	}

}