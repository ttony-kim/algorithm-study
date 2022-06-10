package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_2775 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][] = new int[15][14];
		for(int i = 0; i < 14; i ++) {
			arr[0][i] = i + 1;
		}
		
		for(int i = 1; i < 15; i ++) {
			for(int j = 0; j < 14; j ++) {
				if(j == 0) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i][j-1] + arr[i-1][j];
				}
			}
		}
		
		try {
			int T = Integer.parseInt(br.readLine());
			int k, n;
			for(int i = 0; i < T; i ++) {
				k = Integer.parseInt(br.readLine());
				n = Integer.parseInt(br.readLine());
				System.out.println(arr[k][n-1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
