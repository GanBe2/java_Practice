package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekP10815 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> hash = new HashSet<>();
		StringTokenizer st;
		
		int m = Integer.parseInt(input.readLine());
		st = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < m; i++) {
			hash.add(Integer.parseInt(st.nextToken()));
		}
		
		int n = Integer.parseInt(input.readLine());
		st = new StringTokenizer(input.readLine());
		boolean hasCard;
		
		for (int i = 0; i < n; i++) {
			hasCard = hash.contains(Integer.parseInt(st.nextToken()));
			if (hasCard==true) {
				output.append('1');
			}
			if (hasCard==false) {
				output.append('0');
			}
			output.append(' ');
		}
		
		output.flush();
		output.close();
		input.close();
	}

}
