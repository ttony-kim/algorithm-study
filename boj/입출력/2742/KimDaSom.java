package boj.입출력;

import java.util.Scanner;

public class problem_2742 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = N; i > 0 ; i--) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
