package boj.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem_1759 {
	
	public static String strArr[];
	public static String password[];
	public static int L, C;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String split[] = br.readLine().split(" ");
			L = Integer.parseInt(split[0]);
			C = Integer.parseInt(split[1]);
			
			strArr = br.readLine().split(" ");
			password = new String[L]; 
			//정렬
			Arrays.sort(strArr);
			getPassword(0, 0);
			
			System.out.print(sb);
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getPassword(int n, int k) {
		for(int i = n ; i < C; i ++) {
			password[k] = strArr[i];
			
			if(k != L-1) {
				getPassword(i+1, k+1);
			} else {
				if(check()) {
					print();
				}
			}
		}
	}
	
	public static boolean check() {
		int p = 0; // 모음: 최소 한개
		int q = 0; // 자음: 최소 두개
		for(int i = 0; i < L; i ++) {
			if("a".equals(password[i]) || "e".equals(password[i]) || "i".equals(password[i]) || "o".equals(password[i]) || "u".equals(password[i])) {
				p++;
			} else {
				q++;
			}
		}
		if(p >= 1 && q >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void print() {
		for(int i = 0; i < L; i ++) {
			sb.append(password[i]);
		}
		sb.append("\n");
	}
}
