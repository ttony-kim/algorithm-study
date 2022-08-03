package boj.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 * 
 * 시간 제한	메모리 제한
 * 2 초	512 MB
 * 
 * 문제
 * 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
 * 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
 * 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
 * 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
 * N = 7인 경우에 다음과 같은 상담 일정표를 보자.
 * 
 * 1일	2일	3일	4일	5일	6일	7일
 * Ti	3	5	1	1	2	4	2
 * Pi	10	20	10	20	15	40	200
 * 
 * 1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
 * 상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 
 * 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
 * 또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
 * 퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
 * 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
 * 둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
 * 
 * 출력
 * 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
 * 
 */
public class problem_14501 {
	// 이 문제를 어떻게 DP로 풀까 고민 > DP는 중복된 연산을 하지 않는다 > 연산한 값을 저장하는 변수가 필요
	// 첫번째 날 부터 모든 경우의 수를 트리로 만들어 보니 중복되는 연산을 발견 할 수 있었다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// tArr = 기간, pArr = 금액, result = index일 부터 시작 시 max 금액 값
		// 모든 arr은 index 1~N 까지 -> 1부터 시작해서 크기는 N+1까지 잡음
		int N = Integer.parseInt(br.readLine());
		int tArr[] = new int[N+1];
		int pArr[] = new int[N+1];
		int result[] = new int[N+1];
		
		String lines[];
		for(int i = 1; i <= N; i ++) {
			lines = br.readLine().split(" ");
			tArr[i] = Integer.parseInt(lines[0]);
			pArr[i] = Integer.parseInt(lines[1]);
		}
		
		br.close();
		
		int max;
		
		// 뒤의 일수부터 접근한다.
		for(int i = N; i > 0; i --) {
			// 해당 일(i)과 걸리는 기간(tArr[i])가 주어진 N보다 클 때는 상담하지 못하므로 0 (기간을 더할 때 당일이 포함되므로 N+1)
			if(tArr[i] + i > N+1) {
				result[i] = 0;
			// 해당 일은 상담이 가능하다.
			} else {
				// 해당 일(i) 시작 시 금액은 최소 pArr[i]
				max = pArr[i];
				// 해당 일 상담을 진행하고 다음 진행 할 수 있는 기간은 i(해당 일) + tArr[i](상담기간) 이다.
				// j 부터 N 까지 하나씩 선택 한다. 해당 result[j]는 이미 j날을 선택할 경우 최대값을 담아 놓은 것이기 때문에 max값과 비교하면서 최대 max값을 넣어준다.
				for(int j = i + tArr[i]; j <= N; j ++) {
					if(max < pArr[i] + result[j]) {
						max = pArr[i] + result[j];
					}
				}
				// 해당 일을 선택 했을 때 max값을 result[i]에 넣는다.
				result[i] = max;
			}
		}
		
		// max값 중 최대 max값을 찾아서 출력
		max = result[0];
		for(int i = 1; i <= N; i ++) {
			if(result[i] > max) {
				max = result[i];
			}
		}
		
		System.out.println(max);
		
	}

}
