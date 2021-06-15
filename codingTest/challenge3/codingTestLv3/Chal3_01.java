package codingTestLv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Chal3_01 {
	public static void main(String[] args) {//프로그래머스 lv3 가장 먼 노드
		
	}
	
	
	 public int solution(int n, int[][] edge) {
	        int result = 1;
	        
	        List<ArrayList<Integer>> list = new ArrayList<>();
	        
	        for(int i = 0; i<edge.length; i++){ 
	            list.add(new ArrayList<Integer>());
	        }
	        
	        
	        for(int [] node : edge){
	            int node1 = node[0];
	            int node2 = node[1];
	            
	            list.get(node1).add(node2);
	            list.get(node2).add(node1);
	        }
	        
	        int [] dist = new int[n + 1]; //1번 node로 부터의 거리
	        
	        boolean []visited = new boolean [n + 1];
	        
	        Queue<Integer> que = new LinkedList<>();
	        
	        que.add(1);
	        visited[1] = true;
	        
	        
	        
	        while(!que.isEmpty()) {
	            int current = que.poll();
	            
	            for(int v : list.get(current)) {
	                if(!visited[v])  {
	                    dist[v] = dist[current] + 1;
	                    visited[v] = true;
	                    que.add(v);
	                }
	            }
	            
	        }
	        
	        
	        Arrays.sort(dist);
	        System.out.println(Arrays.toString(dist));
	        
	        
	        int max = dist[dist.length - 1];
	        for(int i = dist.length - 2; i>= 0; i--) {
	            if(dist[i] == max){
	                result ++;
	            } else{
	                break;
	            }
	        }
	        
	        
	        
	        
	        return result;
	        
	        
	    }
}
