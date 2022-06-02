package boj.입출력;

import java.util.Scanner;

public class problem_2442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		/*for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N-(i+1) ; j ++) {
				sb.append(" ");
			}
			for(int j = 0 ; j < N-(N-(i+1)); j ++) {
				sb.append("*");
			}
			for(int j = 0 ; j < (N-1); j ++) {
				if(i > j) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}*/
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N-(i+1) ; j ++) {
				sb.append(" ");
			}
			for(int j = 0 ; j < (2*(i+1))-1 ; j ++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
