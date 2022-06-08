package boj.기본수학;

import java.util.Scanner;

public class problem_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int result = 1;
		int i = 1;
		
		while(true) {
			if(result >= N) {
				break;
			}
			result += 6*i;
			i++;
		}
		System.out.println(i);
	}

}
