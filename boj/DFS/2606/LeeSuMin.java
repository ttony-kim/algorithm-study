import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	static void dfs(int node) {
		visited[node] = true;

		for (int i = 0, len = list.get(node).size(); i < len; i++) {
			int neighborNode = list.get(node).get(i);
			if (!visited[neighborNode]) {
				dfs(neighborNode);
				result++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		dfs(1);

		bw.write(result + "");
		bw.close();
		br.close();
	}
}