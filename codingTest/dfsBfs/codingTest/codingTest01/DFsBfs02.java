package codingTest.codingTest01;

import java.util.LinkedList;
import java.util.Queue;

public class DFsBfs02 {
	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String begin = "hit";
		String target = "cog";
		
		DFsBfs02 app = new DFsBfs02();
		int result = app.solution(begin, target, words);
		System.out.println("result :: "+result);
	}
	
	public int solution(String begin, String target, String[] words) {
	   int answer = 0;
	   boolean []visited = new boolean[words.length]; 
	   
	   
	  Queue<Node> queue = new LinkedList<Node>();
	  queue.offer(new Node(begin,0));// 처음 0
	   
	   while(!queue.isEmpty()) {
		   Node current = queue.poll();
		   if(current.word.equals(target)) {//현재 문자와 같다면
			   answer = current.edge;
			   break;
		   } 
			
		   for(int i=0;i<words.length; i++) {
			   if(!visited[i] && next(current.word,words[i])) {
				   visited[i] = !visited[i];
				   queue.offer(new Node(words[i], current.edge+1));
			   }
		   }
	   }
	   
	   return answer;
	}
	public static boolean next(String current, String next) {
		int cnt = 0;
		for(int i=0;i<current.length(); i++) {
			if(current.charAt(i) != next.charAt(i)) {
				cnt++;
			}
			if(cnt > 1) {
				return false;
			}
		}
		return true;
	}
	
	public class Node{
		private String word;
		private int edge;//정답 까지 가는 depth
		
		public Node(String word, int edge) {
			this.word = word;
			this.edge = edge;
		}
	}
}
