package codingTest01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		 int[] arr = {0,3,2,0,8,5,0, 1};
		
		
		
	}
	
	 public int[] moveZeroes(int[] arr) {
		 
		
		 int [] result;
		 List<Integer> list  = new ArrayList<Integer>();
		 List<Integer> zList  = new ArrayList<Integer>();
		 for(int i=0;i<arr.length; i++) {
			 if(arr[i] != 0) {
				 list.add(i);
			 }else {
				 zList.add(i);
			 }
		 }
		 for(int i=0;i<zList.size(); i++)
			 list.add(i);
		 result = new int[list.size()];
		 for(int i=0; i<list.size(); i++) {
			 result[i] = i;
			 System.out.println();
		 }
		 
		 
		 
		 return result;
	 }

}
