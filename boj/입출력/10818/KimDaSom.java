package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_10818 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String lines = br.readLine();
			int min = 1000001, max = -1000001, n;
			
			/*String [] arrLine = lines.split(" ");
			
			for(int i = 0; i < arrLine.length ; i ++) {
				n = Integer.parseInt(arrLine[i]);
				if(i == 0) {
					min = n;
					max = n;
				} else {
					if(min > n) {
						min = n;
					} 
					if(max < n) {
						max = n;
					}
				}
			}*/
			// 배열은 최악의 경우 시간복잡도 O(N^2), 배열을 사용하지 않을 경우 시간복잡도 O(N)
			StringTokenizer st = new StringTokenizer(lines);
			while(st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken());
				if(min > n) {
					min = n;
				}
				if(max < n) {
					max = n;
				}
			}
			
			System.out.println(min + " " + max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
