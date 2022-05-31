package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_1924 {
	public static void main(String[] args) {
		int [] arrDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String [] arrDayOfTheWeek = {"SUN", "MON","TUE", "WED", "THU", "FRI", "SAT"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] splits = br.readLine().split(" ");
			int month = Integer.parseInt(splits[0]);
			int day = Integer.parseInt(splits[1]);
			int result = 0;
			
			for(int i = 1 ; i < month ; i ++) {
				result += arrDay[i-1];
			}
			
			result += day;
			
			System.out.println(arrDayOfTheWeek[result%7]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
