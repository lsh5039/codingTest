package codintTest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chal002 {
	public static void main(String[] args) {
		Chal002 app = new Chal002();
		System.out.println("결과 : "+app.solution("100-200*300-500+20"));
	}
	
	
	public long solution(String expression) {
        long answer = 0;
        String []num = expression.replaceAll("[^0-9]", "/").split("/");
        List<String> numList = new ArrayList<>(Arrays.asList(num));
        String []oper = expression.replaceAll("[0-9]", "").trim().split("");
        List<String> operList = new ArrayList<>(Arrays.asList(oper));
      
        List<String> resultList = new ArrayList<>();
        
        
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(oper));
        
        List<Integer> star = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        
        for(int i = 0; i<oper.length; i++) {
            if(num.equals("*")){
                star.add(i);
            } else if(num.equals("+")){
                plus.add(i);
            } else{
                minus.add(i);
            }
        }
        
        
        
        
        
        
        //case 1: * > + > -
       
        for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
          //  System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
        
        for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
         //   System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
           // System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
        //System.out.println("ara : "+numList);
        resultList.addAll(numList);
        
        
        
        numList = new ArrayList<>(Arrays.asList(num));
        operList = new ArrayList<>(Arrays.asList(oper));
        
        //case 2: * > - > +
       for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
          //  System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
        
       
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
         //   System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
           // System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        resultList.addAll(numList);
        
        //case 3: + > * > -
         numList = new ArrayList<>(Arrays.asList(num));
        operList = new ArrayList<>(Arrays.asList(oper));
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
           // System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        
       for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
            //System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
        
       
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
           // System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
        
        resultList.addAll(numList);
        
         
        //case 4: + > - > *
        
        numList = new ArrayList<>(Arrays.asList(num));
        operList = new ArrayList<>(Arrays.asList(oper));
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
           // System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        
      
        
       
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
           // System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
            //System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
        
        resultList.addAll(numList);
        
        //case 5: - > * >+
          numList = new ArrayList<>(Arrays.asList(num));
        operList = new ArrayList<>(Arrays.asList(oper));
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
           // System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
            //System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
           // System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        
        resultList.addAll(numList);
        
        //case 6: - > + > *
        
          numList = new ArrayList<>(Arrays.asList(num));
        operList = new ArrayList<>(Arrays.asList(oper));
        
        for(int idx = 0; idx<operList.size(); idx++){
           // System.out.println("numArr : "+numList);
            //System.out.println("arra : "+operList);
            if(!operList.get(idx).equals("-"))
                continue;
            
           // System.out.println("뺄셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left - right));
            idx--;
        }
        
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("+"))
                continue;
            
           // System.out.println("덧셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left + right));
           idx--;
        }
        
         for(int idx = 0; idx<operList.size(); idx++){
            if(!operList.get(idx).equals("*"))
                continue;
            
            //System.out.println("곱셈");
            long left = Long.parseLong(numList.get(idx));
            long right = Long.parseLong(numList.get(idx + 1));
            numList.remove(idx);
            operList.remove(idx);
            numList.set(idx, String.valueOf(left * right));
            idx--;
        }
        
        resultList.addAll(numList);
        
        //resultList.sort(null);
        
        System.out.println("결과 list : "+resultList);
        
        List<Long> resultIntList = new ArrayList<>();
        for(String param : resultList) {
        	resultIntList.add(Math.abs(Long.parseLong(param)));
        }
        resultIntList.sort(null);
        System.out.println(resultIntList);
        
        return resultIntList.get(resultIntList.size() - 1);
    }
}
