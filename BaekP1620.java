package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/*첫째 줄: 도감에 들어있는 포켓몬 수n, 문제의 개수m
둘째 줄~n : 순서대로 번호를 매길 수 있음. 한줄에 한놈
다음줄~m : 문제. 문제가 글이면 번호, 번호면 글 출력
해쉬맵이면 될 것 같음 */
public class BaekP1620 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, String> intKeyMap = new HashMap<>();
	static HashMap<String, Integer> strKeyMap = new HashMap<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub  
		String[] words = input.readLine().split(" ");
		int n = Integer.parseInt(words[0]);
		int m = Integer.parseInt(words[1]);
		
		for (int i = 0; i < n; i++) {
			String name = input.readLine();
			intKeyMap.put(i+1, name);
			strKeyMap.put(name, i+1);
		}
		
		for (int i = 0; i < m; i++) {
			String question = input.readLine();
			sb.append(getAnswer(question)+'\n');
		}
		
		output.append(sb);
		output.flush();
		
		input.close();
		output.close();
	}
	
	private static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	private static String getAnswer(String q) {
			String answer;
			if (isInt(q)) {
				answer=intKeyMap.get(Integer.parseInt(q)); //숫자키니까 string이 밸류
				return answer;
			} else {
				answer=Integer.toString(strKeyMap.get(q)); //string키니까 int가 밸류
			return answer;
		}
	}
}
