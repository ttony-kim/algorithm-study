package boj.기본수학;

import java.util.Scanner;

public class problem_2581 {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.close();
		int min = N + 1;
		int sum = 0;
		for(int i = M; i <= N; i ++) {
			if(isPrime(i)) {
				sum += i;
				if(min > i) {
					min = i;
				}
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static boolean isPrime(int n) {
		if(n == 1) {
			return false;
		}
		boolean flag = true;
		
		for(int i = 2; i <= Math.sqrt(n); i ++) {
			if(n%i == 0) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

}
