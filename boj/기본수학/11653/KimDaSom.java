package boj.기본수학;

import java.util.Scanner;

public class problem_11653 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		sc.close();
		int i = 2;
		while(true) {
			if(n == 1) {
				break;
			}
			if(n%i == 0) {
				sb.append(i).append("\n");
				n = n/i;
			} else {
				i++;
			}
		}
		System.out.println(sb);
	}

}
