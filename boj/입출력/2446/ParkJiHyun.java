package home.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine()); 
		
		int height = (n-1)*2 + 1;
		int maxStar = (n-1)*2 + 1;
		int starCnt = (n-1)*2 + 1;
		for(int i=0; i<height; i++) {
			if(i < n) {
				for(int k=0; k<i; k++) System.out.print(" ");
				for(int j=0; j<starCnt; j++)System.out.print("*");
				if(i == n-1) {
					starCnt +=2;
				}else {
					starCnt-=2;
				}
			}else {
				int spaceEach = (maxStar - starCnt)/2;
				for(int k=0; k<spaceEach; k++) System.out.print(" ");
				for(int j=0; j<starCnt; j++)System.out.print("*");
				starCnt+=2;
			}
			System.out.println();
		}
		
		
		
		br.close();
	}

}
