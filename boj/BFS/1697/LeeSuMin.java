import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);

		int[] visited = new int[100001];

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == K) break;
			int next1 = temp * 2;
			int next2 = temp + 1;
			int next3 = temp - 1;
			// next1 > 2 > 3 순서로 하면 문제 틀려서 순서 바꿈
			if (next3 >= 0 && visited[next3] == 0) {
				q.add(next3);
				visited[next3] = visited[temp] + 1;
			}
			if (next2 < visited.length && visited[next2] == 0) {
				q.add(next2);
				visited[next2] = visited[temp] + 1;
			}
			if (next1 < visited.length && visited[next1] == 0) {
				q.add(next1);
				visited[next1] = visited[temp] + 1;
			}
		}
		System.out.println(visited[K]);
	}
}