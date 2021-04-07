package codingTest03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main03 {
	
	public class Program {
		private int percent;
		private final int speeds;
		private int count = 0;
		
		public Program(int percent, int speeds) {
			this.percent =percent;
			this.speeds = speeds;
		}

		public int getPercent() {
			return percent;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getSpeeds() {
			return speeds;
		}

		@Override
		public String toString() {
			return "Program [count=" + count + "]";
		}
		
		
		
		
	}
	
	
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int current = 0; //가리키는 idx
        int[] arr = new int[progresses.length - 1];//대기중인 완성된 progresses 저장
        int arrIdx = 0;
        int maxTime = 0;//총 경과시간
        
        List<Program> list = new ArrayList<Program>();
        for(int i=0; i<progresses.length-1; i++) {
        	Program prg = new Program(progresses[i], speeds[i]);
        	while(true) {
        		prg.setPercent(prg.getPercent()+prg.getSpeeds());
        		prg.setCount(prg.getCount() + 1);
        		if(prg.getPercent() >= 100) {
        			break;
        		}
        		 
        	}
        	arr[current++] = prg.getCount();
        	list.add(prg);
        	if(maxTime > prg.getCount()) {
        		maxTime = prg.getCount();
        	}
        	
        }
        answer = new int[arr.length-1];
        System.out.println(Arrays.toString(arr));
        System.out.println(list.toString());
        int index = 0;//비교타겟
        int target = 0;//중심
		int cnt = 0;//종료된 개수
		int arrIndex = 0;  
		
		
		while(true) {
			int num = arr[target];
			System.out.println("num :: "+num);
			
			for(int i = index;i<arr.length-1; i++) {
				arr[i] = arr[i] - num;
				if(arr[i]<=0) {//프로세스종료
					cnt++;
					index++;
				}else {//프로세스 비종료
					answer[arrIndex++] =cnt;
					System.out.println("answer : "+Arrays.toString(answer));
					cnt = 0;
					target = index;
					break;//for문 종료
				}
				System.out.println(i+"번째 arr"+Arrays.toString(answer));
			}
			if(index == arr.length-1) {
				return answer;
			}
			
			
			
		}
		
		
		
		
		
    }
	
	
	
	
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99}; 
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		Main03 main = new Main03();
		int result[] = main.solution(progresses, speeds);
		System.out.println("result :: "+Arrays.toString(result));
	}
}


