import java.util.PriorityQueue;

public class ProgrammersTemplete {
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int s : scoville) {
			q.add(s);
		}

		int answer = 0;

		while (!q.isEmpty()) {
			int first = q.poll();
			if (first >= K)
				break;
			if (q.isEmpty()) {
				answer = -1;
				break;
			}
			int second = q.poll();
			q.add(first + second * 2);
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] s1 = { 1, 2, 3, 9, 10, 12 };
		System.out.println(solution(s1, 7));
	}
}