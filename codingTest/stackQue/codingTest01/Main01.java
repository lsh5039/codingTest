package codingTest01;

import java.util.LinkedList;
import java.util.List;

public class Main01 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		List<int[]> queue = new LinkedList<int[]>();
		
		
		int answer = 0;

		int current = 0;
		int totalWeight = 0;
		while (true) {

			// 다리위에 올라가 있는 트럭이 있다면 시간 1씩 감소 (0 이하면 삭제)
			for (int j = 0; j < queue.size();) {

				if (--queue.get(j)[1] == 0) {
					totalWeight -= queue.get(j)[0];
					queue.remove(j);
				} else {
					j++;
				}
			}

			// "현재 차례의 트럭 무게 + 다리위에 놓인 총 트럭 무게"가 weight 보다 작다면 다리에 올라감
			if (current < truck_weights.length && truck_weights[current] + totalWeight <= weight) {
				totalWeight += truck_weights[current];
				queue.add(new int[] {truck_weights[current], bridge_length });
				
				current++;
			}
			// 1초 증가
			answer += 1;

			// 다리에 트럭이 더이상 없으면 종료
			if (queue.size() == 0) {
				break;
			}

		}
		
		return answer;
		}
		
		
			
			
        
	
	public static void main(String[] args) {
		int truck_weights[] = {7,4,5,6};// 문제의 트럭
	
		
		
		Main01 main = new Main01();
		int bridge_length = 2;
		int weight = 10;
		
		int reuslt = main.solution(bridge_length, weight, truck_weights);
		System.out.println("reuslt :: "+reuslt);
	}
	
}
