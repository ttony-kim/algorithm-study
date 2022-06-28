package boj.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 트리 순회
 * https://www.acmicpc.net/problem/1991
 * 
 * 시간제한, 메모리제한
 * 2초, 128 MB
 * 
 * 문제
 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
 * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
 * 
 * 출력
 * 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */
public class problem_1991 {
	static String arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			// 완전 이진 트리로 설정: N개 일때 (2^n+1)개의 배열 필요 -> 1부터 배열 시작이니깐 +1
			arr = new String[(int) Math.pow(2, N) + 2];
			String splits[];
			int index = 1, totalIndex = 1;
			
			for(int i = 1; i <= N; i ++) {
				splits = br.readLine().split(" ");
				for(int j = 1; j <= totalIndex; j ++) {
					if(splits[0].equals(arr[j])) {
						index = j;
						break;
					}
				}
				arr[index] = splits[0];
				arr[2*index] = splits[1];
				arr[(2*index)+1] = splits[2];
				if(totalIndex < (2*index)+1) {
					totalIndex = (2*index)+1;
				}
			}
			preorder(1);
			sb.append("\n");
			inorder(1);
			sb.append("\n");
			postorder(1);
			System.out.print(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 전위 순회 (루트) (왼쪽자식) (오른쪽자식)
	public static void preorder(int n) {
		if(arr[n] != null && !".".equals(arr[n])) {
			sb.append(arr[n]);
		} else {
			return;
		}
		preorder(2*n);
		preorder(2*n + 1);
	}
	
	// 중위 순회 (왼쪽자식) (루트) (오른쪽 자식)
	public static void inorder(int n) {
		if(arr[n] == null || ".".equals(arr[n])) {
			return;
		}
		inorder(2*n);
		sb.append(arr[n]);
		inorder(2*n + 1);
	}
	
	// 후위 순회 (왼쪽자식) (오른쪽자식) (루트)
	public static void postorder(int n) {
		if(arr[n] == null || ".".equals(arr[n])) {
			return;
		}
		postorder(2*n);
		postorder(2*n + 1);
		sb.append(arr[n]);
	}
}
