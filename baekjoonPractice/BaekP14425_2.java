package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP14425_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		int result=0;
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			set.add(input.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			if (set.contains(input.readLine())) result++;
		}
		
		System.out.println(result);

	}
}
