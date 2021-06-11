package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Chal01 {
	
	//프로그래머스 카카오 [1차] 뉴스 클러스터링
	
	
	  public int solution(String str1, String str2) {
	        
	         final int NUM = 65536;
	        
	        int result = 0;
	        
	        str1 = str1.toUpperCase();
	        str2 = str2.toUpperCase();
	       
	        List<String> l1 = new ArrayList<String>();
	        List<String> l2 = new ArrayList<String>();
	        
	        for(int i = 0; i<str1.length()-1; i++){
	            String param = Character.toString(str1.charAt(i)) + Character.toString(str1.charAt(i+1));
	            
	            boolean chk = true;
	            
	             for(int k = 0; k<param.length(); k++){
	                if(!Character.toString(param.charAt(k)).matches("[A-Z]")){
	                    chk = false;
	                }
	            }
	            if(chk){
	                l1.add(param);    
	            }
	            
	        }
	        
	        for(int i = 0; i<str2.length()-1; i++){
	            String param = Character.toString(str2.charAt(i)) + Character.toString(str2.charAt(i+1));
	            boolean chk = true;
	            
	            for(int k = 0; k<param.length(); k++){
	                if(!Character.toString(param.charAt(k)).matches("[A-Z]")){
	                    chk = false;
	                }
	            }
	            if(chk){
	                l2.add(param);    
	            }
	        }
	        
	        
	        
	        l1.sort(null);
	        l2.sort(null);
	        
	        if(l1.size() == 0 && l2.size() == 0){
	            return NUM;
	        }
	        
	        System.out.println("l1 : "+l1);
	        System.out.println("l2 : "+l2);
	        
	        
	     
	        
	        List<String> u = new ArrayList<String>();
	        List<String> n = new ArrayList<String>();
	        
	       for(String s : l1){
	          if(l2.remove(s)){
	            n.add(s);
	          }
	          u.add(s);
	      }
	      
	      for(String s : l2){
	          u.add(s);
	      }
	        
	        float uNum = u.size();
	        float nNum = n.size();
	        
	        System.out.println((nNum/uNum));
	        
	        
	        
	        result = (int)Math.floor((nNum/uNum) * NUM);
	        
	        
	        
	        return result;
	    }
}
