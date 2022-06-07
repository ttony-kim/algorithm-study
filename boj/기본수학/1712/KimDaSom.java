package boj.기본수학;

import java.util.Scanner;

public class problem_1712 {

	public static void main(String[] args) {
		// 해당문제는 숫자가 커서 for문이 아닌 방정식으로 한번에 풀어야한다.
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		
		sc.close();
		if(B < C) {
			System.out.println(A/(C-B) +1);
		} else {
			System.out.println("-1");
		}
	}

}
