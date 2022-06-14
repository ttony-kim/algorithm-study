package boj.기본수학;

import java.util.Scanner;

public class problem_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
	
		sc.close();
		StringBuilder sb = new StringBuilder();
		for(int i = M; i <= N; i ++) {
			if(isPrime(i)) {
				sb.append(i).append("\n");
			};
		}
		System.out.println(sb);
	}
	
	public static boolean isPrime(int n) {
		boolean flag = true;
		if(n == 1) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(n); i ++) {
			if(n%i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
