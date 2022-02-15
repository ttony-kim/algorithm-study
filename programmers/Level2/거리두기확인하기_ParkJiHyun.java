import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
    	for(int i = 0; i<5; i++) {
    		answer[i] = eachResult(places[i]);
    	}
        return answer;
    }
    
    public int eachResult(String[] places) {
    	int answer = 1;
    	
    	String[][] room = new String[5][5];
    	List<int[]> list = new ArrayList<int[]>();

    	for(int i = 0; i<5; i++) {
    		for(int j = 0; j<5; j++) {
    			String val = String.valueOf(places[i].charAt(j));
    			room[i][j] = val;
    			if(val.equals("P")) {
    				int[] pLoc = {i,j};
    				list.add(pLoc);
    			}
    		}
    	}
    	
    	for(int i = 0; i<list.size(); i++) {
    		int r1 = list.get(i)[0];
    		int c1 = list.get(i)[1];
    		for(int j=i; j<list.size(); j++) {
    			if(i == j) continue;
    			int r2 = list.get(j)[0];
    			int c2 = list.get(j)[1];
    			int md = Math.abs(r1-r2) + Math.abs(c1-c2);
    			if(md <= 2) {
    				
    				if(md == 2) {
    					if(r1 == r2 && c1 != c2) {
    						if(String.valueOf(room[r1][c1+1]).equals("O") 
                               || String.valueOf(room[r1][c1+1]).equals("P")) {
    							answer = 0;
    							return answer;
    						}
    					}else if(r1 != r2 && c1 == c2){
    						if(String.valueOf(room[r1+1][c1]).equals("O") 
                               || String.valueOf(room[r1+1][c1]).equals("P")) {
    							answer = 0;
    							return answer;
    						}
    						
    					}else {
    						int compJ = c1+1;
    						if(r1<r2 && c1>c2) compJ = c1-1;
    						if(String.valueOf(room[r1][compJ]).equals("O")
    								|| String.valueOf(room[r1][compJ]).equals("P")
    								|| String.valueOf(room[r1+1][c1]).equals("O")
    								|| String.valueOf(room[r1][compJ]).equals("P")) {
    							answer = 0;
    							return answer;
    						}
    					}
    				}else {
    					answer = 0;
    					return answer;
    				}
    			}
    			
    		}
    	}
    	return answer;
    }
}