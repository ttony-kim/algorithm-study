package boj.브루트포스;

import java.util.Scanner;

public class problem_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		String str = "666";
		int preStr = 0;
		int cnt = 1;
		
		total:
		while(cnt != N) {
			preStr ++;
			if((preStr-6)%10 == 0) {
				int k, j;
				switch(check(preStr)) {
					case 1:
						k = 660;
						j = 9;
						break;
					case 2:
						k = 600;
						j = 99;
						break;
					default:
						k = 0;
						j = 999;
				}
				for(int i = k; i <= k+j; i ++) {
					cnt ++;
					if(cnt == N) {
						str = String.valueOf(i);
						break total;
					}
				}
			} else {
				cnt ++;
			}
		}
		System.out.println((preStr > 0) ? preStr + str :  str);
	}
	
	public static int check(int n) {
		StringBuilder sb = new StringBuilder();
		int k = (int) (Math.floor(Math.log10(n)) + 1);
		for(int i = 0; i < k; i ++) {
			sb.append("6");
		}
		
		String str = sb.toString();
		for(int i = 0; i <= k; i ++) {
			if(String.valueOf(n).contains(str.substring(i))) {
				str = str.substring(i);
				break;
			}
		}
		
		return str.length();
	}

}
