import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[N+1]; // 컴퓨터가 1번부터라서 +1 해줘야했음
		int[][] inputVal = new int[K][2];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			inputVal[i][0] = one;
			inputVal[i][1] = two;
			if (one == 1) {
				if (!visited[one]) {
					q.add(one);
					visited[one] = true;
				}
				if (!visited[two]) {
					q.add(two);
					visited[two] = true;
				}
			}
			if (two == 1) {
				if (!visited[two]) {
					q.add(two);
					visited[two] = true;
				}
				if (!visited[one]) {
					q.add(one);
					visited[one] = true;
				}
			}
		}

		if (q.poll() != 1) {
			System.out.println(0);
			return;
		}

		int result = 0;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int[] input : inputVal) {
				if (visited[0] && visited[1])
					continue;
				if (temp == input[0] && !visited[input[1]]) {
					q.add(input[1]);
					visited[input[1]] = true;
				}
				if (temp == input[1] && !visited[input[0]]) {
					q.add(input[0]);
					visited[input[0]] = true;
				}
			}
			result++;
		}

		System.out.println(result);
	}
}