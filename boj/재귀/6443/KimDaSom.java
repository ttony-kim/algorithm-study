package boj.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_6443 {
	public static char anagramArr[];
	public static int visited[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			char arr[];
			for(int i = 0; i < N; i ++) {
				visited = new int[26];
				arr = br.readLine().toCharArray();
				anagramArr = new char[arr.length];
				for(char c : arr) {
					visited[c-'a'] ++;
				}
				anagram(0, arr.length);
			}
			
			System.out.print(sb);
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void anagram(int k, int length) {
		if(length == 0) {
			print();
			return;
		}
		for(int i = 0; i < 26; i ++) {
			if(visited[i] > 0) {
				anagramArr[k] = (char)(97 + i);
				visited[i] -= 1;
				anagram(k+1, length-1);
				visited[i] += 1;
			}
		}
	}
	
	public static void print() {
		for(char c : anagramArr) {
			sb.append(c);
		}
		sb.append("\n");
	}
}

