package codingTestfullSearch;

import java.util.Arrays;

import javax.tools.Diagnostic;

public class FullSearch01 {
	public static void main(String[] args) {
		int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		System.out.println(Arrays.toString(solution1(13)));
		System.out.println(Arrays.toString(solution2(13)));
		System.out.println(Arrays.toString(solution3(13)));
		FullSearch01 app = new FullSearch01();
		System.out.println(Arrays.toString(app.solution(answers)));
	}
	
	public int[] solution(int[] answers) {
        int persion1 = compareArr(answers, solution1(answers.length));
		int persion2 = compareArr(answers, solution2(answers.length));
		int persion3 = compareArr(answers, solution3(answers.length));
		
		int [] arr = {};
		if(persion1 >= persion2 && persion1 >= persion3) {//1 !
			if(persion1 == persion2 && persion2 == persion3) {
				return new int[] {1,2,3};
			} else if(persion1 == persion2) {
				return new int[] {1,2};
			} else if(persion1 == persion3) {
				return new int[] {1,3};
			} else {
				return new int[] {1};
			}
			
			
		} else if(persion2 >= persion1 && persion2 >= persion3) {//2 !
			if(persion2 == persion3) {
				return new int[] {2,3};
			}else {
				return new int[] {2};
			}
			
		} else{//3 !
				return new int[] {3};
		}
		
    }
		
	public static int[] solution1(int lenght) {
		int [] arr = new int[lenght];
		int first = 1;
		
		for(int i =0;i<lenght;i++) {
			if(first > 5) 
				first = 1;
			
			arr[i] = first++;
		}
		return arr;
	}
	
	public static int[] solution2(int length) {
		int [] arr = new int[length];
		int first = 1;
		for(int i =0;i<length;i++) {
			if(i%2 == 0 ) {
				arr[i] = 2;
			}else {
				if(first == 6) {
					first = 1;
				}
				arr[i] = first++;
				
				if(first == 2) {
					first++;
				}
			}
		}
		
		return arr;
	}
	
	public static int[] solution3(int length) {
		int [] arr = new int[length];
		int first = 3;
		for(int i=0; i<length; i++) {// 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
			if(i%2 == 0 && i!= 0) {
				switch(first) {
					case 1:
						first++;
						break;
					case 2:
						first = 4;
						break;
					case 3:
						first = 1;
						break;
					case 4:
						first++;
						break;
					case 5:
						first = 3;
						break;
				}
			}
			arr[i] = first;
		}
		
		
		
		
		return arr;
	}
	
	public static int  compareArr(int[]arr , int[] arr2 ) {
		int result = 0;
		
		for(int i=0;i<arr.length; i++) {
			if(arr[i] == arr2[i]) {
				result++;
			}
		}
		
		
		
		
		return result;
	}
	
	
}
