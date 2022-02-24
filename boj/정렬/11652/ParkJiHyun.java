package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < N; i++) {
        	Long key = Long.parseLong(br.readLine());
        	if(map.containsKey(key)) {
        		map.put(key, map.get(key) + 1);
        	}else {
        		map.put(key, 1);
        	}
        }
        
        int max = 0;
        Long result = -1l;
        for(Long key : map.keySet()) {
        	int val = map.get(key);
        	if(max<=val) {
        		if(max == val) {
    				if(result > key) {
    					result = key;
    				}
        		}else {
        			result = key;
        		}
        		max = val;
        	}
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        
        br.close();
        bw.flush();
        bw.close();
        
	}
}
