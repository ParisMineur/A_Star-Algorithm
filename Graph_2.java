public class Graph {
	private Node[][] graph;
	private Node start;
	private Node end;
	
	
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
		graph = new Node[25][25];
		
		int x, y;
		for(x=0;x<graph.length;x++) {
			for(y=0;y<graph[0].length;y++) {
				graph[x][y] = new Node(x,y,"*",true);
			}
		}
		
		
		//��ʼ��start��end��λ�úͱ��
		start = graph[2][2];
		end = graph[18][15];
		start.set_value("S");
		end.set_value("E");
		start.set_reachable(false);
		end.set_reachable(true);
		
		
		//�����ϰ����λ��
		for(int i=0;i<6;i++){
			graph[i][4].set_value("/");
			graph[i][4].set_reachable(false);
		}
		for(int i=0;i<20;i++){
			graph[9][i].set_value("/");
			graph[9][i].set_reachable(false);
		}
		for(int i=24;i>5;i--){
			graph[13][i].set_value("/");
			graph[13][i].set_reachable(false);
		}
		for(int i=14;i<21;i++){
			graph[i][6].set_value("/");
			graph[i][6].set_reachable(false);
		}
		for(int i=3;i<22;i++){
			graph[21][i].set_value("/");
			graph[21][i].set_reachable(false);
		}
		for(int i=16;i<21;i++){
			graph[i][21].set_value("/");
			graph[i][21].set_reachable(false);
		}
		for(int i=9;i<22;i++){
			graph[16][i].set_value("/");
			graph[16][i].set_reachable(false);
		}
		for(int i=15;i<20;i++){
			graph[i][9].set_value("/");
			graph[i][9].set_reachable(false);
		}
		for(int i=12;i<22;i++){
			graph[16][i].set_value("/");
			graph[16][i].set_reachable(false);
		}
		
		
		
		
		//��������forѭ��д���˵�ͼ�ı߽�
		for(x=0;x<graph.length;x++) {
			graph[x][0].set_value("||");
			graph[x][0].set_reachable(false);
			
			graph[x][24].set_value("||");
			graph[x][24].set_reachable(false);
		}
		
		for(y=0;y<graph[0].length;y++) {
			graph[0][y].set_value("=");
			graph[0][y].set_reachable(false);
			
			graph[24][y].set_value("=");
			graph[24][y].set_reachable(false);
		}
	}

	
	//������ͼ
	public void ShowGraph() {
		int i,j;
		for(i=0;i<graph.length;i++) {
			for(j=0;j<graph[0].length;j++) {
				System.out.print(graph[i][j].get_value() + " ");
			}
			
			System.out.println();
		}
	}
}