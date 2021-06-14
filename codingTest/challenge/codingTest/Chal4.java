package codingTest;

import java.util.Arrays;

public class Chal4 {
	public static void main(String[] args) {
		  Chal4 app = new Chal4();
		  int []result = app.solution("110010101001");
		 System.out.println(Arrays.toString(result));
		 
	}
	public int[] solution(String s) {
        int zeroCnt = 0;
        int roof = 0;
        StringBuilder builder =  new StringBuilder(s);
        
        String num = s;
        
        while(true){
        	builder = new StringBuilder(num);
        
        for(int i = 0; i<builder.length(); i++){
            if(Character.toString(builder.charAt(i)).equals("0")){
            	
            	
                zeroCnt++;
                builder.setCharAt(i, 'A');
                
            }
        }
        String str = builder.toString();
        str = str.replaceAll("A", "");
        
         num = Integer.toBinaryString(str.length());
         
            roof++;
            
            if(num.equals("1")){
                break;
            }
            
        }
        
        
        return new int[]{roof,zeroCnt};
    }
	
	
}
