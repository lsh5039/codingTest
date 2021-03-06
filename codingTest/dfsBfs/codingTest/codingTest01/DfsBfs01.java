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
	  answer = bfs(1, target, numbers, numbers[0])+ bfs(1, target, numbers, -numbers[0]);
	        
	        
	  return answer;
	}
	
	public static int bfs(int idx, int current, int[] numbers, int sum) {//next idx, 현재 target, arr, result value
		if(idx == numbers.length) {//최상위 노드탐색시
			if(sum == current) {//같은결과값
				return 1;
			} else {//다른결과
				return 0;
			}
		}
		int result = 0;
		result +=bfs(idx+1,current, numbers,sum+numbers[idx]);
		result += bfs(idx+1, current, numbers, sum-numbers[idx]);
		return result;
	}
	    
	
	
}


