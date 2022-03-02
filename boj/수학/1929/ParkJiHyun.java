package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int begin = Integer.parseInt(num[0]);
        int end = Integer.parseInt(num[1]);
        
		int[] arr = new int[1000001];
		
		// 배열 초기화
		for(int i=1; i<arr.length; i++) {
			arr[i] = i;
		}

		// 소수 아닌 수 제거
		for(int i = 2; i<arr.length; i++) {
			if(arr[i] == 0) continue;
			for(int j = i + i; j<arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 2; i<arr.length; i++) {
			if(arr[i] == 0) continue;
			if(arr[i] >= begin && arr[i]<= end) {
				bw.write(String.valueOf(arr[i]));
				bw.write("\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
