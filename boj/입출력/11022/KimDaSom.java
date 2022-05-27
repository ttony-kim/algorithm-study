package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_11022 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			int a, b;
			String line;
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i < t ; i ++) {
				line = br.readLine();
				a = line.charAt(0)-48;
				b = line.charAt(2)-48;
				//String + String 보다 StringBuilder 사용 
				//System.out.println("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b));
				sb.setLength(0);
				sb.append("Case #").append(i+1).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b);
				System.out.println(sb);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
