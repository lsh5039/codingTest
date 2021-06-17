package codintTest2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Chal004 {
	public static void main(String[] args) {//프로그래머스 //bsf//  Lv3 네트워크


		Chal004 app = new Chal004();
		
	}
	
       
	  public int solution(int n, int[][] computers) {
	        boolean [][] visited = new boolean[n][n];
	        
	       int result = 0;
	        Queue<Integer> que = new LinkedList<>();
	        
	      
	        for(int i = 0; i<computers.length; i++) {
	            for(int j = 0; j<computers[i].length; j++) {
	                if(computers[i][j] == 1){
	                    result++;
	                    Chal004.bfs(i,computers, visited, que);
	                }
	            }   
	        }
	        
	        
	        return result;
	        
	    }
	    
	    
	    public static void bfs(int current, int[][] computers, boolean[][] visited, Queue<Integer> que){
	        que.add(current);
	        
	        while(!que.isEmpty()){
	            int v = que.poll();
	            Integer target = null;
	            for(int i = 0; i<computers[v].length; i ++) {
	                if(!visited[v][i] && computers[v][i] == 1){//연결됐으나 처음 카운팅
	                    visited[v][i] = true;
	                    visited[i][v] = true;
	                    computers[v][i] = 0;
	                    computers[i][v] = 0;
	                    target = i;
	                      que.add(target);
	                }
	            }
	            
	             
	        }
	        
	        
	       
	        
	        
	        
	        
	    }
	
}
