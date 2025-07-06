package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP1269 {

	public static void main(String[] args) throws IOException {
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());
		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(input.readLine());
		for (int i = 0; i < numA; i++) {
			setA.add(Integer.parseInt(st2.nextToken()));
		}
		StringTokenizer st3 = new StringTokenizer(input.readLine());
		for (int i = 0; i < numB; i++) {
			setB.add(Integer.parseInt(st3.nextToken()));
		}

		Set<Integer> copyA = new HashSet<>(setA);
		copyA.removeAll(setB);

		Set<Integer> copyB = new HashSet<>(setB);
		copyB.removeAll(setA);

		int result = copyA.size() + copyB.size();
		
		output.write(Integer.toString(result));
		output.flush();
		output.close();
		input.close();

	}

}
