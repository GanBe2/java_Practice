package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP108115_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();

		int n = Integer.parseInt(input.readLine());

		StringTokenizer st = new StringTokenizer(input.readLine());

		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(input.readLine());

		StringTokenizer st2 = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < m; i++) {
			if(set.contains(Integer.parseInt(st2.nextToken()))) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append(" ");
		}
		
		output.write(sb.toString());
		output.flush();
		output.close();
		input.close();

	}
	
	

}
