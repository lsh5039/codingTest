package test;

import java.util.Stack;

public class test {
	public static void main(String[] args) {
		int []nums = {1,2,3,4,5};
		test a = new test();
		a.solution(nums);
	}
	
	public int solution(int [] nums) {
		int index = 0;
		
		int n = nums.length;// n : 전체 개수
        int r = 3;// r : 뽑을 개수
        Stack<Integer> st = null;
        
        // index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
     /*   if(r==0){
            //0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로  스택을 출력하고 함수를 종료한다.
            showStack();
            return;
        }*/
         if(n==r){
            //nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
            for(int i=0;i<n;i++)st.add(nums[index+i]);//index부터 n개를 차례대로 스택에 넣고
            //showStack(); //스택을 보여준다.
            for(int i=0;i<n;i++)st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
        }
        else{
            //저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.
             
            //index를 포함하는 경우
            st.add(nums[index]);
            solution(nums); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.
             
            //index를 포함하지 않는 경우
            st.pop(); //index를 제거해주고
            solution(nums); //index를 제외한 상태에서 n-1Cr 진행.
             
             
        }

		
		return st.size();
	//	return 3;
	}

}

