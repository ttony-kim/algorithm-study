package home.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
	 
	    String[][] arr = new String[N][4];
		
	    for(int i=0; i<N; i++) {
	    	String[] inner = new String[4];
        	String[] str = br.readLine().split(" ");
        	inner[0] = str[0];
        	inner[1] = str[1];
        	inner[2] = str[2];
        	inner[3] = str[3];
        	arr[i] = inner;
        }
	    
	    Arrays.sort(arr, (o1, o2) -> {
			if(o1[1].equals(o2[1])) {
				if(o1[2].equals(o2[2])) {
					if(o1[3].equals(o2[3])) {
						return o1[0].compareTo(o2[0]);
					}else {
						return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
					}
				}else{
					return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
				}
			}else {
				return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for(int i=0, iLen = arr.length; i<iLen; i++) {
	    	bw.write(String.valueOf(arr[i][0]));
	    	if(i<iLen-1) bw.write("\n");
	    }

	    br.close();
	    bw.flush();
	    bw.close();
	}
}
