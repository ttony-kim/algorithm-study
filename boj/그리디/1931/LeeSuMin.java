import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meetings = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] time = new int[2];
			time[0] = Integer.parseInt(st.nextToken());
			time[1] = Integer.parseInt(st.nextToken());
			meetings[i] = time;
		}
		
		Arrays.sort(meetings, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}	
		});
		
		int tempMeetingEnd = -1;
		int result = 0;
		
		for(int[] m : meetings) {
			if(tempMeetingEnd <= m[0]) {
				tempMeetingEnd = m[1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}