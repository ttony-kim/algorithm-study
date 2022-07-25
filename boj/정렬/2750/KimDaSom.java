package boj.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 * 
 * 시간 제한, 메모리 제한
 * 1 초, 128 MB
 * 
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 */
public class problem_2750 {
	static int n;
	static int arr[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		for(int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		selectionSort();
		countingSort();
	}

	static void selectionSort() {
		int temp, minIndex;
		for(int i = 0; i < n; i ++) {
			minIndex = i;
			for(int j = i+1; j < n ; j ++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		print(arr);
	}
	
	// 카운팅 정렬 참고
	// https://st-lab.tistory.com/104
	static void countingSort() {
		boolean countArr[] = new boolean[2001];
		for(int i = 0; i < n; i ++) {
			countArr[arr[i] + 1000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 2001; i ++) {
			if(countArr[i]) {
				sb.append(i-1000).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static void print(int arr[]) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i ++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
}
