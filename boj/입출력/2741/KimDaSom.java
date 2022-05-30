package boj.입출력;

import java.util.Scanner;

public class problem_2741 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			//출력 값이 많을 때는 StringBuilder를 사용하기
//			System.out.println(i);
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
	}
}
