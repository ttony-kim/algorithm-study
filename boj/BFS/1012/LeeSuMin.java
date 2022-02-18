import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int[][] bat) {
		int result = 0;
		int[] posX = { 1, -1, 0, 0 };
		int[] posY = { 0, 0, 1, -1 };
		Queue<Pos> q = new LinkedList<Pos>();

		for (int i = 0; i < bat.length; i++) {
			for (int j = 0; j < bat[0].length; j++) {
				if (bat[i][j] != 0) {
					q.add(new Pos(j, i));
					while (!q.isEmpty()) {
						Pos tempPos = q.poll();
						int newPosX = 0;
						int newPosY = 0;
						for (int k = 0; k < 4; k++) {
							newPosX = tempPos.x + posX[k];
							newPosY = tempPos.y + posY[k];
							if (newPosX < 0 || newPosX >= bat[0].length || newPosY < 0 || newPosY >= bat.length) continue;
							if (bat[newPosY][newPosX] != 0) {
								q.add(new Pos(newPosX, newPosY));
								bat[newPosY][newPosX] = 0;
							}
						}
					}
					result++;
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] bat = new int[N][M];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				bat[y][x] = 1;
			}
			bfs(bat);
		}
	}
}