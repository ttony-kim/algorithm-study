package boj.입출력;

import java.util.Scanner;

public class problem_10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N-(i+1); j ++) {
				sb.append(" ");
			}
			for(int j = 0; j < 2*i+1 ; j ++) {
				if(i == 0) {
					sb.append("*");
				} else if (i == N-1) {
					sb.append("*");
				} else {
					if(j == 0 || j == (2*i)) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
