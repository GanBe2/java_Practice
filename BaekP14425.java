package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BaekP14425 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hash = new HashSet<>();
		
		String[] times = input.readLine().split(" ");
		int n = Integer.parseInt(times[0]);
		int m = Integer.parseInt(times[1]);
		
		for (int i = 0; i < n; i++) {
			hash.add(input.readLine());
		}
		
		boolean hashword;
		int corr=0;
		
		for (int i = 0; i < m; i++) {
			hashword = hash.contains(input.readLine());
			if (hashword == true) 
				corr++;
		}
		
		System.out.println(corr);

	}

}
