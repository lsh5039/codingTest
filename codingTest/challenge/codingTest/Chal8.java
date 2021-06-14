package codingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Chal8 {
	public static void main(String[] args) {
		Chal8 app = new Chal8();
		
		int [] param = {44, 1, 0, 0, 31, 25};
		int [] param2 = {31, 10, 45, 1, 6, 19};
		
		System.out.println(Arrays.toString(app.solution(param, param2)));
		
	}
	
	 public int[] solution(int[] lottos, int[] win_nums) {
	        
	        Set<Integer>set = new HashSet<Integer>();
	        
	        for(int n : win_nums){
	            set.add(n);
	        }
	        
	        
	        int tCnt = 0;//일치수
	        int blackCnt = 0; //지워진 수
	        int fCnt = 0;//틀린 수
	        for(int n : lottos){
	            if(n == 0)//지워짐
	                blackCnt++;
	             else{
	                if(set.contains(n)){
	                    
	                    tCnt++;
	                } else{
	                    fCnt++;
	                }
	            }
	            
	        }
	        
	        int max =  tCnt+blackCnt;
	        int min = tCnt;
	        
	        if(max == 6){
	            max = 1;
	        } else if(max == 5){
	            max = 2;
	        } else if(max == 4){
	            max = 3;
	        } else if(max == 3){
	            max = 4;
	        } else if(max == 2){
	            max = 5;
	        } else{
	            max = 6;
	        }
	        
	        if(min == 6){
	            min = 1;
	        } else if(min == 5){
	            min = 2;
	        } else if(min == 4){
	            min = 3;
	        } else if(min == 3){
	            min = 4;
	        } else if(min == 2){
	            min = 5;
	        } else{
	            min = 6;
	        }
	        
	        
	        
	        return new int[]{max,min};
	    }

}