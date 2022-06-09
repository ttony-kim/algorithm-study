package boj.기본수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 낮에 무조건 정상에 오른다.
 * 1일째 낮: A
 * 2일째 낮: A-B+A
 * 3일째 낮: A-B+A-B+A
 * ...
 * N일째 낮: (N-1)(A-B)+A
 * 
 * 식
 * (N-1)(A-B)+A >= V
 * N >= (V-B)/(A-B)
 * 
 * N은 무조건 정수, 나머지가 나올 경우 무조건 올림
 */
public class problem_2869 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A, B, V;
		
		try {
			String arr[] = br.readLine().split(" ");
			br.close();
			A = Integer.parseInt(arr[0]);
			B = Integer.parseInt(arr[1]);
			V = Integer.parseInt(arr[2]);
			int N = (V-B)/(A-B);
			if((V-B)%(A-B) != 0) {
				System.out.println(N+1);
			} else {
				System.out.println(N);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

