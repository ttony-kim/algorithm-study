package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Sort4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
	 
	    String[][] arr = new String[N][3];
		
	    for(int i=0; i<N; i++) {
	    	String[] inner = new String[3];
        	String[] str = br.readLine().split(" ");
        	inner[0] = str[0];
        	inner[1] = String.valueOf(i);
        	inner[2] = str[1];
        	arr[i] = inner;
        }
	    
	    Arrays.sort(arr, (o1, o2) -> {
			if(o1[0].equals(o2[0])) {
				return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
			}else {
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for(int i=0, iLen = arr.length; i<iLen; i++) {
	    	for(int j=0, jLen = arr[i].length; j<jLen; j++) {
	    		if(j != 1) {
	    			bw.write(String.valueOf(arr[i][j]));
	    			if(j == 0) bw.write(" ");
	    		}
	    	}
	    	if(i<iLen-1) bw.write("\n");
	    }

	    br.close();
	    bw.flush();
	    bw.close();
	}
}
