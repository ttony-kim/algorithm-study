package home.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Sort1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner 입력속도 느림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
	 
	    Integer[] arr = new Integer[N];
	    
	    for(int i=0; i<N; ) {
	    	Integer n = Integer.parseInt(br.readLine());
	    	if(i == 0) {
	    		arr[i] = n;
	    		i++;
	    		continue;
	    	}
			for(int j=0; j<i; j++) {
				if(arr[j] != n) {
					arr[i] = n;
					i++;
					break;
				}else {
					break;
				}
				
			}
	    }
	    
	    Arrays.sort(arr);
	    //Arrays.sort(int[]) 시간복잡도: O(n^2)
	    //Arrays.sort(Object[]) 효율성 높음

	    // System.out.println() 느림
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for(int i=0, len = arr.length; i<len; i++) {
	    	bw.write(String.valueOf(arr[i]));
	    	if(i<len-1) bw.write("\n");
	    }

	    br.close();
	    bw.flush();
	    bw.close();
	}

	// 퀵소트 구현...
	public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료
        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
}
