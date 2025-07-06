package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP7785_2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<String> set = new HashSet<>();
		String name, now;
		
		int n = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			name=st.nextToken();
			now=st.nextToken();
			if(now=="enter") set.add(name);
			else set.remove(name);
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		
		Collections.sort(list, Collections.reverseOrder());
		
		for (int i = 0; i < list.size(); i++) {
			
		}
	}
}
