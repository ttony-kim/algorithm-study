package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem_10951 {

	public static void main(String[] args) {
		//Scanner ���
		/*Scanner sc = new Scanner(System.in);
		int a, b;
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
		sc.close();*/
		
		//BufferedReader ���, StringTokenizer ���
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				System.out.println(a+b);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//BufferedReader ���, charAt ���
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while((line = br.readLine()) != null) {
				int a = line.charAt(0)-48;
				int b = line.charAt(2)-48;
				System.out.println(a+b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
