package boj.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 분해합
 * https://www.acmicpc.net/problem/2231
 * 
 * 시간제한, 메모리제한
 * 2 초, 192 MB
 * 
 * 문제
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
 * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 
 * 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
 * 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 * 
 * 출력
 * 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 */
public class problem_2231 {
	public static void main(String[] args) {
//		bruteForce();
		applyBruteForce();
	}
	
	// 1부터 차례대로 자리수를 더해봐서 결과를 찾음
	public static void bruteForce() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int j, sum;
		for(int i = 1; i < N; i ++) {
			j = i;
			sum = i;
			while(j >= 1) {
				sum += j%10;
				j = j/10;
			}
			if(sum == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
	
	//	N = M + SUB(M)
	//	M = N - SUB(M)
	// 	M < N
	//	=> SUB(M)은 M의 각 자리수 합, 각 자리는 0~9
	//	SUB(M)의 값이 클수록 M은 작은수부터 시작
	//	SUB(M)의 최대 값은 N의 자리수 * 9 => 여기부터 시작한다.
	public static void applyBruteForce() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int N = Integer.parseInt(line);
			
			int j, sum;
			for(int i = N-(9*line.length()); i < N; i ++) {
				j = i;
				sum = i;
				while(j >= 1) {
					sum += j%10;
					j = j/10;
				}
				if(sum == N) {
					System.out.println(i);
					return;
				}
			}
			System.out.println(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
