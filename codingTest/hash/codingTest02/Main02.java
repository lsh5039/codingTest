package codingTest02;

import java.util.HashMap;
import java.util.Map;

public class Main02 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0; i<phone_book.length; i++) {
			for(int j=1; j<phone_book.length; j++) {
				if(phone_book[j].contains(phone_book[i])) {
					if(!phone_book[j].equals(phone_book[i])){
						
						answer = false;
					}
				}else {
					
				}
			}
		}
        
        
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		//String[] phone_book =  {"12","123","1235","567","88"};
		//String[] phone_book =  {"123","456","789"};
		//String[] phone_book =  {"12","123","1235","567","88"};
		String[] phone_book =  {"12","121233","1231235","567123","881232145"};
		
		Main02 main = new Main02();
		System.out.println(main.solution(phone_book));
		
		
		
		
	}
}
