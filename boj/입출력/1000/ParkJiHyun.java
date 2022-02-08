package home.io;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        
        int n = 0;
		int m = 0;
        for (int i=0; i<2; i++) {
            if (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(n+m);
        
        sc.close();
	}

}
