package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		List<Integer> list = new ArrayList<Integer>();

		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(input2[i]));
		}
		
		Collections.sort(list);	// 직접 구현보다 내장 라이브러리 쓰는 게 더 빠름..
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(list.get(k-1)));
        
        br.close();
        bw.flush();
        bw.close();
        
	}
}
