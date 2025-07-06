package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*듣잡n, 보잡m
 * 듣잡 n줄 나오고 보잡 n줄 나옴
 * 이름을 key, 등장횟수를 value
 * value가 2일 경우, 출력*/

public class BaekP1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Set<String>set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n ; i++) {
			String name = input.readLine();
			set.add(name);
		}
		for (int i = 0; i < m; i++) {
			String name = input.readLine();
			if(set.contains(name)) result.add(name);
		}
		
		Collections.sort(result);
		int personNum=0;
		
		for (int i = 0; i < result.size(); i++) {
			personNum++;
			sb.append(result.get(i)+"\n");
		}
		
		output.write(personNum+"\n"+sb.toString());
		output.flush();
		output.close();
		input.close();

	}

}
