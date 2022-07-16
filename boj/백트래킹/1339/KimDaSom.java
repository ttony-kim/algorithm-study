package boj.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 단어수학
 * https://www.acmicpc.net/problem/1339
 * 
 * 시간 제한, 메모리 제한
 * 2 초, 256 MB
 * 
 * 문제
 * 민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.
 * 단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다.
 * 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다.
 * 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.
 * 예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 
 * 두 수의 합은 99437이 되어서 최대가 될 것이다.
 * N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 
 * 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.
 * 
 * 출력
 * 첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.
 *
 */
public class problem_1339 {

	// N개의 단어 리스트
	static List<char[]> strList = new ArrayList<>();
	// A~Z 중 나온 알파벳 리스트
	static List<Character> keyList = new ArrayList<>();
	// 위의 keyList 사용 flag 리스트
	static List<Boolean> keyBoolList = new ArrayList<>();
	// key: 알파벳, value: 주어진 숫자
	static Map<Character, Integer> map = new HashMap<>();
	// keyList size
	static int size = 0;
	// 최대값
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str;
		char[] cArr = new char[10];
		
		for(int i = 0; i < N; i ++) {
			str = br.readLine();
			cArr = str.toCharArray();
			// 1. 한 줄 읽어서 List에 담기
			strList.add(cArr);
			// 2. 읽은 단어를 char[] 에 담고 하나씩 keyList와 keyBoolList에 담는다. -> 알파벳 전부가 아닌 입력된 알파벳만 넣으려고
			for(char c : cArr) {
				if(!keyList.contains(c)) {
					keyList.add(c);
					keyBoolList.add(true);
				}
			}
		}
		size = keyList.size();
		// 3. 파라미터에 0~9중 최대값인 9를 넣어준다. -> 최대값을 구하는 문제기 때문에 9부터 주어져야함
		setHashMap(9);
		System.out.println(max);
	}
	
	// key 리스트가 {A, B, C} 인 경우 A = 9, B = 8, C = 7로 Map에 key, value로 넣어 준 뒤
	// 만들어진 Map값으로 단어들의 합을 계산하는 getMaxValue() 호출
	public static void setHashMap(int k) {
		// 5. k값이 9 - key List의 length일 경우 단어들의 합을 계산하는 함수 호출
		if(k == (9 - size)) {
			getMaxValue();
			return;
		}
		// 4. for문은 key리스트를 돌면서 Map에 <key, 주어질값 k> 을 넣는다.
		for(int i = 0; i < size; i ++) {
			if(keyBoolList.get(i)) {
				map.put(keyList.get(i), k);
				keyBoolList.set(i, false);
				setHashMap(k-1);
				// 5. 리턴이 되면 해당 값 다시 true(사용안했음) 값으로 지정 -> ABC > ACB > BAC > BCA > CAB > CBA 순으로 값을 줄 수 있다.
				keyBoolList.set(i, true);
			}
		}
	}
	
	public static void getMaxValue() {
		int sum = 0;
		int k, length;
		// 6. 입력 받았던 단어리스트들을 하나씩 뺀다.
		for(char[] cArr : strList) {
			k = 1;
			length = cArr.length - 1;
			// 7. 1의 자리수 부터 시작한다. 자리수는 k로 증가 될때마다 k * 10을 해준다. Map에서 해당 알파벳에 주어진 값들을 찾는다.
			// ex) ABC일 경우 (C * 1) + (B * 10) + (A * 100)
			for(int i = length; i >= 0; i --) {
				sum += map.get(cArr[i]) * k;
				k = k * 10;
			}
		}
		
		// 8. max보다 클경우 저장
		if(sum > max) {
			max = sum;
		}
	}
}
