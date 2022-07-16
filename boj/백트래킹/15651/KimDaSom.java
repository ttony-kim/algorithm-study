package boj.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * N과 M (3)
 * https://www.acmicpc.net/problem/15651
 * 
 * 시간제한, 메모리제한
 * 1 초,	512 MB
 *
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 * 
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class problem_15651 {

	static int arr[];
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String splits[] = br.readLine().split(" ");
			br.close();
			
			n = Integer.parseInt(splits[0]);
			// 1. 한줄에 출력해야 할 개수: M -> arr[M] 생성
			arr = new int[Integer.parseInt(splits[1])];
			// 2. sequence의 매개변수는 arr의 index
			sequence(0);
			System.out.print(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sequence(int k) {
		// 5. k가 arr의 마지막 index일 경우 
		if(k == arr.length - 1) {
			// 6. arr의 마지막 인덱스의 자리도 1~N의 수, 마지막이기 때문에 출력(print)
			for(int i = 0; i < n; i ++) {
				arr[k] = i+1;
				print();
			}
			// 7. 마지막 인덱스의 N까지 출력을 했으면 리턴을 해서 마지막 index의 전 index의 자리 수를 +1 해준다.
			return;
		}
		// 3. arr의 각 자리는 1~N의 수, 1부터 증가
		for(int i = 0; i < n; i ++) {
			arr[k] = i+1;
			// 4. arr의 index를 k -> k+1로 증가
			sequence(k+1);
		}
	}
	
	public static void print() {
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
	}
}
