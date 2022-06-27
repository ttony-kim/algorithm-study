package boj.재귀;

import java.util.Scanner;

public class problem_17478 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		bot(N, sb, 0);
		System.out.print(sb);
	}
	
	public static void bot(int n, StringBuilder sb, int k) {
		String underbar = "";
		for(int i = 0 ; i < k; i ++) {
			underbar += "____";
		}
		sb.append(underbar);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		if(n == 0) {
			sb.append(underbar);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else {
			sb.append(underbar);
			sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(underbar);
		    sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		    sb.append(underbar);
		    sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		    bot(n-1, sb, k+1);
		}
		sb.append(underbar);
		sb.append("라고 답변하였지.\n");
	}
}
