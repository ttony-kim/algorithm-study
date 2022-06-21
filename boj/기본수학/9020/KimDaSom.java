package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_9020 {
	static boolean[] primeArr = new boolean[10001];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makePrime();
		try {
			int T = Integer.parseInt(br.readLine());
			int n;
			StringBuffer sb = new StringBuffer();
			
			int min, max;
			
//			for(int i = 0; i < T ; i ++) {
//				n = Integer.parseInt(br.readLine());
//				min = n;
//				max = 0;
//				for(int j = n-1; j > 1; j --) {
//					if(j == min) {
//						break;
//					}
//					if(!primeArr[j]) {
//						if(!primeArr[n-j]) {
//							if(Math.abs(max-min) > (n-j)-(j)) {
//								min = n-j;
//								max = j;
//							}
//						}
//					}
//				}
//				sb.append(min).append(" ").append(max).append("\n");
//			}
			
			for(int i = 0; i < T ; i ++) {
				n = Integer.parseInt(br.readLine());
				min = max = n/2;
				while(true) {
					if(!(primeArr[min] || primeArr[max])) {
						sb.append(min).append(" ").append(max).append("\n");
						break;
					}
					min--;
					max++;
				}
			}
			System.out.println(sb);
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void makePrime() {
		primeArr[0] = primeArr[1] = true;
		
		for(int i = 2; i <= Math.sqrt(primeArr.length); i ++) {
			if(primeArr[i]) {
				continue;
			}
			for(int j = 2; j * i < primeArr.length; j ++) {
				primeArr[j * i] = true;
			}
		}
	}

}
