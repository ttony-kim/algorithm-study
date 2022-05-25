package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_10953 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			String line;
			int a, b;
			for(int i = 0 ; i < T ; i ++) {
				line = br.readLine();
				a = line.charAt(0) - 48;
				b = line.charAt(2) - 48;
				System.out.println(a+b);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
