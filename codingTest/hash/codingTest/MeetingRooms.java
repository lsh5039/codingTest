package codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Interval {
	int start;
	int end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class MeetingRooms {
	public boolean solve(Interval[] intervals) {
		boolean isRight = true;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		List<int[]> resultList = new ArrayList<int[]>();
		String result = "";
		
		for(int i=0; i<intervals.length; i++) {
			for(int j=intervals[i].start;j<intervals[i].end; j++) {
				String strInt = Integer.toString(j);
				if(result.contains(strInt)) {
					return false;
				} else {
					result+=strInt+" ";
				}
			}
			
		}
	
		
		
		
		
		
		
		return isRight;
		
	}
	public static void main(String[] args) {
		//Interval i1 = new Interval(0,30);
		Interval i2 = new Interval(5,10);
		Interval i3 = new Interval(15,20);
		
		Interval[] arr= {i2,i3}; 
		
		MeetingRooms mt = new MeetingRooms();
		System.out.println("결과는 ::: "+ mt.solve(arr));
		
	}
}

