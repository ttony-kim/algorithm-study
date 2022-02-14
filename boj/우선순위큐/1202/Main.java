import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Jewel {
		int m;
		int v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewels, (c1, c2) -> {
			return Integer.compare(c1.m, c2.m);
		});
		Arrays.sort(bags);

		long result = 0; // 데이터 범위 확인 필요 int 써서 계속 틀림
		int tempIdx = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int bag : bags) {
			for (int i = tempIdx; i < N; i++, tempIdx++) { // tempIdx 안하고 loop 전체 돌리면 시간초과 남
				if (bag < jewels[i].m)
					break;
				q.add(jewels[i].v);
			}
			if (!q.isEmpty()) {
				result += q.poll();
			}
		}

		System.out.println(result);
	}
}