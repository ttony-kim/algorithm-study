package boj.DP;

import java.util.Scanner;
/**
 * 알고리즘 수업 - 피보나치 수 1
 * https://www.acmicpc.net/problem/24416
 * 
 * 시간 제한, 메모리 제한
 * 1 초, 512 MB
 * 
 * 문제
 * 오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 * 오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자.
 * 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
 * 
 * 입력
 * 첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.
 * 
 * 출력
 * 코드1 코드2 실행 횟수를 한 줄에 출력한다.
 */
public class problem_24416 {

	static int fibCount = 0;
	static int fibonacciCount = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		fib(n);
		fibonacci(n);
		
		System.out.println(fibCount + " " + fibonacciCount);
	}
	
	// 재귀
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			fibCount ++;
			return 1;
		} else {
			return (fib(n - 1) + fib(n -2));
		}
	}
	
	// DP
	public static int fibonacci(int n) {
		int fibArray[] = new int[41];
		fibArray[1] = fibArray[2] = 1;
		for(int i = 3; i <= n; i ++) {
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
			fibonacciCount ++;
		}
		return fibArray[n];
	}

}
