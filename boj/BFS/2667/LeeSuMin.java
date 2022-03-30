import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int totalCount;
	static ArrayList<Integer> counts;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y) {
		int[] dX = { 1, -1, 0, 0 }; // 남북동서
		int[] dY = { 0, 0, 1, -1 };
		int count = 1;

		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dX[i];
				int ny = pos.y + dY[i];
				if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph.length) continue;
				if (visited[nx][ny] || graph[nx][ny] == 0) continue;
				q.add(new Pos(nx, ny));
				visited[nx][ny] = true;
				count++;
			}
		}

		totalCount++;
		counts.add(count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		totalCount = 0;
		graph = new int[n][n];
		visited = new boolean[n][n];
		counts = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				graph[i][j] = arr[j] - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(totalCount);
		Collections.sort(counts);
		for (int c : counts) {
			System.out.println(c);
		}
	}
}