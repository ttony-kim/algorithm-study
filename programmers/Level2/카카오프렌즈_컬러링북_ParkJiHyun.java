// 테스트케이스
// int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
// int[] answer = solution(6, 4, picture);	// [2,6]
		
import java.util.TreeSet;

class Solution {
    
    // 입력 파라미터 카피
    int x;
	int y;
	int[][] pic;   
    
	int areaIdx;    // 영역 번호 
	int[][] copy;   // 영역 번호 별로 색칠하기
	int cell;       // 원소값
	int sum;        // 영역 크기
    
    public int[] solution(int m, int n, int[][] picture) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        
        int numberOfArea = 0;
        
        // 전역변수 초기화
        x = m;
        y = n;
        pic = picture;
        copy = new int[m][n];
        areaIdx = 1;
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		sum = 0;
        		cell = picture[i][j];
        		if(DFS(i,j)) {
        			if(cell!=0) ++numberOfArea;
        			if(cell!=0) tree.add(sum);
        			++areaIdx;
        		}
        	}
        }
                
        int maxSizeOfOneArea = tree.last();
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public boolean DFS(int i, int j) {
    	if(i < 0 || i>=x || j>=y | j<0) return false;
    	
    	if(pic[i][j] == cell && copy[i][j] == 0) {
    		copy[i][j] = areaIdx;	// 방문처리 및 해당영역인덱스로 재할당
    		++sum;
    		DFS(i+1, j);	// 상
    		DFS(i-1, j);	// 하
    		DFS(i, j-1);	// 좌
    		DFS(i, j+1);	// 우
    		return true;
    	}
    	return false;
    }
}