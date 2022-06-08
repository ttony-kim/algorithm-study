package boj.기본수학;

import java.util.Scanner;

public class problem_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		int i = 1;
		while(cnt + i < N) {
			cnt += i;
			i++;
		}
		if(i%2 != 0) {
			System.out.println((i-(N-cnt-1)) + "/" + (1+(N-cnt-1)));
		} else {
			System.out.println((1+(N-cnt-1)) + "/" + (i-(N-cnt-1)));
		}
		
		
		/*int arr[] = {1, 1};
		// arr index 위치
		int plus = 0; 
		int minus = 1;
		// 대각선 한줄 개수
		int sum = 2; 
		int j = 1;
		
		if(N == 1) {
			System.out.println(arr[0]+"/"+arr[1]);
		} else {
			loop: 
			while(true) {
				if(sum%2 == 0) {
					plus = 0;
					minus = 1;
				} else {
					plus = 1;
					minus = 0;
				}
				for(int i = 0; i < sum ; i ++) {
					if(i == 0) {
						arr[minus] +=1;
					} else {
						arr[plus] += 1;
						arr[minus] -= 1;	
					}
					j++;
					if(j == N) {
						break loop;
					}
				}
				sum++;
			}
			System.out.println(arr[0]+"/"+arr[1]);
		}
		*/
	}
}
