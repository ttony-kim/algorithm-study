import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersTemplete {
	static String[] place;

	static class Pos {
		int x;
		int y;
		int d;

		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean find(Pos startPos) {
		int[] posX = { 1, -1, 0, 0 };
		int[] posY = { 0, 0, 1, -1 };
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visited = new boolean[5][5];

		q.add(new Pos(startPos.x, startPos.y, startPos.d));
		visited[startPos.x][startPos.y] = true;

		while (!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int newX = pos.x + posX[i];
				int newY = pos.y + posY[i];
				int newD = pos.d + 1;
				if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5 || visited[newX][newY]) continue;
				if (place[newX].charAt(newY) == 'X') continue;
				if (place[newX].charAt(newY) == 'P' && newD <= 2) {
					return false;
				}
				q.add(new Pos(newX, newY, newD));
				visited[newX][newY] = true;
			}
		}
		return true;
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			boolean isSafe = true;
			place = places[i];
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					if (place[x].charAt(y) == 'P') {
						isSafe = find(new Pos(x, y, 0));
						if (!isSafe) break;
					}
				}
				if (!isSafe) break;
			}
			answer[i] = isSafe ? 1 : 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		String[][] s1 = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] foo = solution(s1);
		for (int f : foo) {
			System.out.print(f + " ");
		}
	}

}
