package codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Graph01 {
	public static void main(String[] args) {
		int[][]edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int n = 6;		
		
		Graph01 app  =new Graph01();
		int result = app.solution(n, edge);
		System.out.println("result :: "+result);
		
		
		
	}
	public int solution(int n, int[][] edge) {
	  int answer = 0;
	  boolean []visited ; 
	  Queue<Integer> que = new LinkedList<Integer>();
	  
	  
	  
	  
	  
	  
	  return answer;
	}
	
	public static void bfs(int v) {
		
	}
	
	
	 public class GraphNode{
	      int vertex;
	      int link;
	      
	      public GraphNode (int vertex, int node) {
	    	  this.vertex = vertex;
	    	  this.link = node;
	      }
	      
	 }
	 

	 

}
