package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Chal3 {
	
	//프로그래머스 예상 대진표
	
	
	public int solution(int n, int a, int b){
        return Chal3.dfs(n,a,b);
    }
    
    public static int dfs(int n, int a, int b){
        int cnt = 0;
        if(a <= n/2 && b> n/2 ||b <= n/2 && a > n/2){//최상단
            while(n != 1){
                n = n/2;
                cnt++;
            }
           return cnt;
        } else if(a > n/2 && b> n/2){// 둘다 우측이면 좌측으로 이동 후 계산
            a = a-n/2; 
            b = b-n/2;
        }
        //한쪽에 있는경우
        
        if(n/2 == 2){
            cnt = cnt+1;
        } else{
            cnt += dfs(n/2, a, b);    
        }
        
       
        return cnt;
       
    }
}
