package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();

		int length1 = Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine()); 

		for (int i = 0; i < length1; i++) {
		    set.add(Integer.parseInt(st.nextToken()));
		}

		int length2 = Integer.parseInt(input.readLine());
		st = new StringTokenizer(input.readLine()); 

		for (int i = 0; i < length2; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    System.out.println(set.contains(num) ? 1 : 0);
		}

	}

}
