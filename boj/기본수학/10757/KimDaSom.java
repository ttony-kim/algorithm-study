package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_10757 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] split = br.readLine().split(" ");
			int max = Math.max(split[0].length(), split[1].length());
			int A [] = new int[max];
			int B [] = new int[max];
			int C [] = new int[max+1];
			
			for(int i = split[0].length()-1, j = 0; i >= 0; i --, j ++) {
				A[j] = split[0].charAt(i)-48;
			}
			for(int i = split[1].length()-1, j = 0; i >= 0; i --, j ++) {
				B[j] = split[1].charAt(i)-48;
			}
			
			int sum = 0;
			int cnt = 0;
			
			for(int i = 0; i < max ; i ++) {
				sum = A[i] + B[i] + cnt;
				if(sum > 9) {
					cnt = 1;
				} else {
					cnt = 0;
				}
				C[i] = sum % 10;
			}
			if(cnt != 0) {
				C[max] = 1;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = C.length-1; i >= 0; i --) {
				sb.append(C[i]);
			}
			if(sb.charAt(0)-48 == 0) {
				System.out.println(sb.substring(1));
			} else {
				System.out.println(sb);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
