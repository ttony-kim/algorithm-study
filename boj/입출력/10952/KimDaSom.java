package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_10952 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			int a, b;
			while((line = br.readLine()) != null) {
				a = line.charAt(0)-48;
				b = line.charAt(2)-48;
				if(a+b != 0) {
					System.out.println(a+b);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
