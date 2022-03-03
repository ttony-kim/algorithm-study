import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		Integer[] array = new Integer[n];
		Integer[] brray = new Integer[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			brray[i] = Integer.parseInt(st2.nextToken());
		}

		Arrays.sort(array, Collections.reverseOrder());
		Arrays.sort(brray);

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += array[i] * brray[i];
		}

		bw.write(result+"");
		bw.close();
		br.close();
	}
}