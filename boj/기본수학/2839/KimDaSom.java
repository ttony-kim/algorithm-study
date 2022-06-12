package boj.기본수학;

import java.util.Scanner;

public class problem_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		if(N%5 == 0) {
			System.out.println(N/5);
		} else if ((N%5)%3 == 0) {
			System.out.println((N/5) + (N%5)/3);
		} else {
			int k = (N/5)-1;
			while(k >= 0) {
				if((N-(5*k))%3 == 0) {
					System.out.println(k+((N-(5*k))/3));
					break;
				}
				k--;
			}
			if(k < 0) {
				System.out.println("-1");
			}
		}
	
	}
}
