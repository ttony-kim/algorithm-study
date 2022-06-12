package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1978 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			br.close();
			int s;
			int cnt = 0;
			boolean flag;
			// 제곱근 사용하기 s의 제곱근 만큼만 체크해보면 된다.
			// s의 제곱근 이상은 약수가 아니거나, 1~s의 제곱근의 약수를 가진 수 
			while(st.hasMoreTokens()) {
				s = Integer.parseInt(st.nextToken());
				if(s == 1) {
					continue;
				}
				flag = true;
				for(int i = 2; i <= Math.sqrt(s); i++) {
					if(s%i == 0) {
						flag = false;
						break;
					}
					if(Math.floor(Math.sqrt(s)) == i) {
						flag = true;
						break;
					}
				}
				if(flag) {
					cnt ++;
				}
			}
//			while(st.hasMoreTokens()) {
//				s = Integer.parseInt(st.nextToken());
//				if(s == 1) {
//					continue;
//				}
//				for(int i = 2; i <= s; i ++) {
//					if(i == s) {
//						cnt++;
//						break;
//					}
//					if(s%i == 0) {
//						break;
//					}
//				}
//			}
			System.out.println(cnt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
