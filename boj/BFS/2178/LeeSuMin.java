import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	private static int N, M;
	private static int[][] map;	
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    
	public static int dfs(int x, int y) {
		Queue<String> q = new LinkedList<>();
		q.offer(x + " " + y);
		
		while(!q.isEmpty()) {
			String[] tempPosition = q.poll().split(" ");
			x = Integer.parseInt(tempPosition[0]);
			y = Integer.parseInt(tempPosition[1]);
			
			for(int i=0; i<4; i++) {
	                int nx = x + dx[i];
	                int ny = y + dy[i];
	                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
	                if (map[nx][ny] == 0) continue;

	                if (map[nx][ny] == 1) {
	                    map[nx][ny] = map[x][y] + 1;
	                    q.offer(nx + " " + ny);
	                } 
			} 
		}
		
		return map[N][M];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		
		for(int i = 1; i < N+1; i++) {
			String line = br.readLine();
			for(int j = 1; j < M+1; j++) {
				map[i][j] = line.charAt(j-1) - '0'; // char to int
			}
		}
		
		System.out.println(dfs(1,1));
	}
}