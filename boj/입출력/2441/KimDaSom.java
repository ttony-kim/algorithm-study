package boj.입출력;

import java.util.Scanner;

public class problem_2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++ ) {
				if(i <= j) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
