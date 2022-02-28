import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] trees = new int[n];
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		int lo = 0;
		int hi = trees[n-1];
		
		while (lo + 1 < hi) { 			// 범위 중요
			long sum = 0;
			int mid = (lo + hi) / 2;

			for (int tree : trees) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}

			if (sum >= m) {
				lo = mid;
			} else {
				hi = mid;
			}
		}

		System.out.println(lo);
	}
}