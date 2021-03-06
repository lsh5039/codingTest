package codingTest04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main04 {
	public static void main(String[] args) {
		/*int location = 0;
		int[] priorities = {1, 1, 9, 1, 1, 1};*/
		int location = 2;
		int[] priorities = {2, 1, 3, 2};
		
		
		Main04 app = new Main04();
		int result = app.solution(priorities, location);
		System.out.println(result);
	}
	


	
	
	
    
    
    public int solution(int[] priorities, int location) {
        
    	  int answer = 0;
          Queue<Printer> q = new LinkedList<>();

  		for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
  			q.offer(new Printer(i, priorities[i]));
  		}

  		while (!q.isEmpty()) {

  			boolean flag = false;
  			int com = q.peek().prior;
  			for (Printer p : q) {
  				if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
  					flag = true;
  				}
  			}
  		
  			
  			

  			if (flag) {
  				q.offer(q.poll());
  			} else {// 현재 맨앞의 숫자가 가장 클 때
  				if (q.poll().location == location) {
  					answer = priorities.length - q.size();
  				}
  			}
  		}
          return answer;
    }
    class Printer {
  		int location;
  		int prior;

  		Printer(int location, int prior) {
  			this.location = location;
  			this.prior = prior;
  		}
  	}
}
