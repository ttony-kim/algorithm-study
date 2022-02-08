package home.io;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 개수 T
		int loop = 0;;
		
		String line_loop = sc.nextLine();
        StringTokenizer st_loop = new StringTokenizer(line_loop);
        for (int i=0; i<1; i++) {
			if (st_loop.hasMoreTokens()) {
				loop = Integer.parseInt(st_loop.nextToken());
			}
		}
		
        // 입력 값 저장 배열
		int[][] intArr = new int[loop][2];
		
		for (int cnt=0; cnt<loop; cnt++) {
	        String line = sc.nextLine();
	        StringTokenizer st = new StringTokenizer(line);
	        int n = 0;
			for (int input=0; input<loop; input++) {
				if (st.hasMoreTokens()) {
					n = Integer.parseInt(st.nextToken());
					intArr[cnt][input] = n;
				}
			}
		}
        
		for(int i = 0; i<intArr.length; i++) {
			System.out.println(intArr[i][0] + intArr[i][1]);
		}
		
        sc.close();
	}

}
