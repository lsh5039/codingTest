package codingTest02;

import java.util.Arrays;

public class Main002 {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};//return 3
		Main002 app = new Main002();
		int result = app.solution(citations);
	}
	//1 9	
	public int solution(int[] citations) {
		 int[] sorted = Arrays.stream(citations).sorted().toArray();
		 System.out.println(Arrays.toString(sorted));
	       int answer = 0;
	       for(int i=sorted.length-1; i>=0; i--){
	          if(sorted[i] > answer){//가운데 index의 숫자가 hIndex
	             answer++;
	          }else{
	              break;
	          }
	       }
	      return answer;
	}
}
