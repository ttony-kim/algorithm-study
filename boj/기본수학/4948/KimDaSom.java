package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_4948 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t;
		StringBuilder sb = new StringBuilder();
		try {
			while(true) {
				t = Integer.parseInt(br.readLine());
				if(t == 0) {
					break;
				}
				sb.append(isPrime(t)).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int isPrime(int n) {
		int cnt = 0;
		boolean flag = true;
		for(int i = n+1; i <= 2*n; i++) {
			if(i == 1) {
				continue;
			}
			flag = true;
			for(int j = 2; j <= Math.sqrt(i); j ++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt ++;
			}
		}
		
		return cnt;
	}

}
