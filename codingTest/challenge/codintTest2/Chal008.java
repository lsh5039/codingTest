package codintTest2;

import java.util.Arrays;

public class Chal008 {
	
	static int max = 0;
	
	public static void main(String[] args) {//프로그래머스 //bsf//  Lv3 네트워크
		int m = 5;
		int n = 5;
		int [][]picture = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
		
		Chal008 app = new Chal008();
		int []result = app.solution(m, n, picture);
		System.out.println("result : "+Arrays.toString(result));
		
	}
		
	public int[] solution(int m, int n, int[][] picture) {
        //max = 0;
        

        int[] answer = new int[2];
      
        
        int num = 0;
        int [][] arr = new int[picture.length][picture[0].length];
        
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                arr[i][j] = picture[i][j];
                
            }
        }
        
        
        
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                long target = arr[i][j];
                if(target != 0){
                   
                    Roof roof = new Roof();
                    roof.setRoof(0);
                
                    num++;//면적의 개수
                   
                    
                    Chal008.dfs(i, j, arr, target, roof);    
                    //maxSizeOfOneArea = Math.max(maxSizeOfOneArea, roof.getRoof());
                }
                
            }
        }
        
        
     
        return new int []{num,max};
    }
    
    public static void dfs(int x, int y, int[][]picture, long target, Roof roof){
      
        
        if(x < 0 || x >= picture.length || y < 0 || y >= picture[0].length || picture[x][y] != target){
            if(roof.getRoof() > max){
                max = roof.getRoof();
            }
            return;
        }
        roof.setRoof(roof.getRoof() + 1);
        
   
            picture[x][y] = 0;
            
            dfs(x+1, y, picture, target, roof); //아래
            dfs(x-1, y, picture, target, roof); // 위
            dfs(x, y+1, picture, target, roof); // 우측
            dfs(x, y-1, picture, target, roof); // 좌측
            
       
    }
    
    
    public class Roof{
        private int roof;//영역 개수
        
        public void setRoof(int roof){
            this.roof = roof;
        }
        
        public int getRoof(){
            return this.roof;
        }
        
        
    }
}