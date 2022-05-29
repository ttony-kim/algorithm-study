package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_11721 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] lines = br.readLine().split("");
			for(int i = 0; i < lines.length; i++) {
				System.out.print(lines[i]);
				if((i+1)%10 == 0) {
					System.out.print("\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
