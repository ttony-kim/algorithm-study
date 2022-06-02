package boj.입출력;

import java.util.Scanner;

public class problem_8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int result = N;
		for(int i = 1 ; i < N ; i ++) {
			result += i;
		}
		System.out.println(result);
	}
}
