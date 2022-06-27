package boj.재귀;

import java.util.Scanner;

public class problem_2447 {
	public static char arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new char[N][N];
		
		drawStar(0, 0, N, 0, false);
		print(N);
		
		sc.close();
		
	}
	
	public static void drawStar(int x, int y, int n, int k, boolean blank) {
		if(n == 3) {
			int cnt = 0;
			for(int i = x; i < 3 + x; i ++) {
				for(int j = y; j < 3 + y; j ++) {
					if(blank) {
						arr[i][j] = ' ';
						continue;
					}
					if(cnt == 4) {
						arr[i][j] = ' ';
					} else {
						arr[i][j] = '*';	
					}
					cnt++;
				}
			}
		} else {
			for(int i = 0; i < 9; i ++) {
				if(i == 4) {
					drawStar(x + ((i/3) * (n/3)), y + ((i%3) * (n/3)), n/3, i, true);
				} else {
					drawStar(x + ((i/3) * (n/3)), y + ((i%3) * (n/3)), n/3, i, blank);
				}
			}
		}
	}
	
	public static void print(int N) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
