package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_10250 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());
			String arr[] = new String[3];
			int H, W, N, floor, ho;
			for(int i = 0; i < T; i ++) {
				arr = br.readLine().split(" ");
				H = Integer.parseInt(arr[0]);
				W = Integer.parseInt(arr[1]);
				N = Integer.parseInt(arr[2]);
				
				if(N%H != 0) {
					floor = N%H;
					ho = N/H + 1;
				} else {
					floor = H;
					ho = N/H;
				}
				
				sb.append(floor);
				if(ho < 10) {
					sb.append("0");
				} 
				sb.append(ho).append("\n");
			}
			System.out.println(sb);
			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
