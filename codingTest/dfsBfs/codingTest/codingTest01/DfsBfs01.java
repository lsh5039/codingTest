package codingTest.codingTest01;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs01 {
	public static void main(String[] args) {
		DfsBfs01 app = new DfsBfs01();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		int result = app.solution(numbers, target);
		System.out.println(result);
	}
	 	public int solution(int[] numbers, int target) {
	        int answer = 0;
	        Queue<Integer> que = new LinkedList<Integer>();
	        
	        for(int i=0;i<numbers.length; i++) {
	        	que.offer(numbers[i]);
	        }
	        
	        int num = que.poll();
	        while(!que.isEmpty()) {
	        	Integer current = que.peek();
	        	
	        	
	        }
	        
	        
	        
	        
	        
	        return answer;
	    }
	    
	    
	
	
}

