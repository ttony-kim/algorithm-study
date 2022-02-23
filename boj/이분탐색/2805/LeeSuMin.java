import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static void search(int[] trees, int target, int start, int end) {
		int result = 0;

		while (start <= end) {
			int total = 0;
			int mid = (start + end) / 2;

			for (int tree : trees) {
				if (tree > trees[mid]) {
					total += tree - trees[mid];
				}
			}

			if (total >= target) {
				result = trees[mid];
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(result);
	}

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
		search(trees, m, 0, trees.length);
	}
}