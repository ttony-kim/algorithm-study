package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
        int A = Integer.parseInt(num[0]);
        int B = Integer.parseInt(num[1]);
        
        int gcd = -1;
        if(A>B) gcd = GCD(A,B);
        else gcd = GCD(B,A);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(gcd));
		bw.write("\n");
		bw.write(String.valueOf(A*B/gcd));

		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int GCD(int A, int B) {
		if(A % B == 0) return B;
		return GCD(B,A%B);
	}
}
