import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = (int) 1e9;
	static int[] cost = new int[1001]; // 최단 거리 정보 cost[index]
	static ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>(); // 간선 정보

	static class City implements Comparable<City> {
		private int index;
		private int cost;

		public City(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getcost() {
			return cost;
		}

		public void setcost(int cost) {
			this.cost = cost;
		}

		@Override
		public int compareTo(City o) {
			// TODO Auto-generated method stub
			return this.cost < o.cost ? -1 : 1;
		}

	}

	static void find(int start) {
		PriorityQueue<City> q = new PriorityQueue<City>();
		q.add(new City(start, 0));
		cost[start] = 0;

		while (!q.isEmpty()) {
			City currCity = q.poll();
			int curIdx = currCity.getIndex();
			int curCost = currCity.getcost();
			if (cost[curIdx] < curCost) continue;
			for (int i = 0, len = graph.get(curIdx).size(); i < len; i++) {
				int tempCost = cost[curIdx] + graph.get(curIdx).get(i).getcost();
				if (tempCost < cost[graph.get(curIdx).get(i).getIndex()]) {
					cost[graph.get(curIdx).get(i).getIndex()] = tempCost;
					q.add(new City(graph.get(curIdx).get(i).getIndex(), tempCost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<City>());
		}

		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new City(end, cost));
		}

		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		// 최단 거리 테이블 초기화
		Arrays.fill(cost, INF);

		find(startCity);

		System.out.println(cost[endCity]);
	}
}