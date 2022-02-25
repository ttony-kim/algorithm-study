package home.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<String> st = new Stack<String>();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<N; i++) {
			String command = br.readLine();
			if(command.contains("push")) {
				st.push(command.split(" ")[1]);
			}else { 
				if(command.equals("pop")) {
					bw.write(!st.empty() ? st.pop() : "-1");
				}else if(command.equals("size")) {
					bw.write(String.valueOf(st.size()));
				}else if(command.equals("empty")) {
					bw.write(st.empty() ? "1" : "0");
				}else if(command.equals("top")) {
					bw.write(!st.empty() ? st.peek() : "-1");
				}
				bw.write("\n");
			}
		}
				
		br.close();
		bw.flush();
		bw.close();
	}
}
