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
		int result = 0;
		boolean find = false;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(K);

		while (!find) {
			int tempSize = q.size();
			while(tempSize > 0) {
				int temp = q.poll();
				int nextTemp1 = temp / 2;
				int nextTemp2 = temp - 1;
				int nextTemp3 = temp + 1;
				if(nextTemp1 == N || nextTemp2 == N || nextTemp3 == N) {
					find = true;
					break;
				}
				if (temp % 2 == 0)
					q.add(nextTemp1);
				q.add(nextTemp2);
				q.add(nextTemp3);
				tempSize--;
			}
			result++;
		}
		
		System.out.println(result);
	}
}