package codingTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Chal7 {
	public static void main(String[] args) {
		Chal7 app = new Chal7();
		int[][] queries ={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(app.solution(6, 6, queries)));
		
	}
	
	 static int[][] map;
	    static int min;
	    public int[] solution(int rows, int columns, int[][] queries) {
	        map = new int[rows + 1][columns + 1];
	        int[] answer = new int[queries.length];
	        int num = 1;
	        for(int i = 1; i <= rows; i++) {
	            for(int j = 1; j <= columns; j++) {
	                map[i][j] = num;
	                num++;
	            }
	        }

	        for(int i = 0; i < queries.length; i++) {
	            answer[i] = rotation(queries[i]);
	        }
	        return answer;
	    }

	    static int rotation(int[] query) {
	        // 직사각형의 가로 세로 길이
	        int xMove = query[2] - query[0];
	        int yMove = query[3] - query[1];

	        // 현재 위치 및 현재 값
	        int nx = query[0];
	        int ny = query[1];
	        int now = map[nx][ny];

	        // 현재값을 최소값으로 초기화
	        min = now;

	        // 오른쪽
	        for(int i = 0; i < yMove; i++) {
	            ny += 1;
	            now = move(nx, ny, now);
	        }

	        // 아래
	        for(int i = 0; i < xMove; i++) {
	            nx += 1;
	            now = move(nx, ny, now);
	        }

	        // 왼쪽
	        for(int i = 0; i < yMove; i++) {
	            ny -= 1;
	            now = move(nx, ny, now);
	        }

	        // 위쪽
	        for(int i = 0; i < xMove; i++) {
	            nx -= 1;
	            now = move(nx, ny, now);
	        }
	        return min;
	    }

	    static int move(int x, int y, int before) {
	        // 이동한 지점의 값을 temp 에 임시 저장
	        int temp = map[x][y];

	        // 최소값 초기화
	        min = Math.min(min, temp);

	        // 이동한 지점의 값을 이전 지점의 값으로 초기화
	        map[x][y] = before;

	        return temp;
	    }

}