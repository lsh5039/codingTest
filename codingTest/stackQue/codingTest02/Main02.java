package codingTest02;

import java.util.Arrays;

public class Main02 {
	public static void main(String[] args) {
		int [] prices = {1, 2, 3, 2, 3};
		
		Main02 main  = new Main02();
		int[] reuslt = main.solution(prices);
		System.out.println("result :: "+Arrays.toString(reuslt));
		
		
	}
	
	
	  public int[] solution(int[] prices) {
	        int[] answer = {};
	        answer = new int[prices.length];
	        int sec = 0; //몇 초뒤에 떨어질건가
	        int current = 0;//비교할거 inedx
	        int target = 0;//비교대상 index
	        int end = prices.length-1;
	        answer[end] = -1;
	        		
	        while(true) {
	        	
	        	if(prices[current] > prices[target] || target == prices.length - 1) {//하락이거나 비교 끝
	        		answer[current] = sec;
	        		current++;
	        		target = current;
	        		sec = 0;
	        	} else {//상승
	        		sec++;
	        		target++;
	        	}
	        	
	        	if(answer[end] != -1) {
	        		return answer;
	        	}
	        		
	        }
	        
	        
	    }
}