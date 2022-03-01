import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] array;

	static int check(int n) {
		int lo = 0;
		int hi = array.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (array[mid] == n) {
				return 1;
			} else if (array[mid] < n) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		array = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(array);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println(check(num));
		}
	}
}