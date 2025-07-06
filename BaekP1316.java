package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BaekP1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		int length = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < length; i++) {
			Set<Character> set = new HashSet<>();
			String word = input.readLine();
			char prev = word.charAt(0);
			boolean isGroupword=true;
			set.add(prev);
			
			for (int j = 1; j < word.length(); j++) {
				//1.만약 이전에 이 글자가 있었나 체크
				//있으면 계속(그룹 단어임) , 없으면 2. set 가능한가. 가능하면 계속(그룹 단어임) 불가능하면 그룹아님.
				char now=word.charAt(j);
				
				if (prev!=now) {
					if(set.contains(now)) {//set 안에 이 글자가 있는가?
						isGroupword=false;
						break;
					}
					set.add(now);
				}
				prev=now;
			}
			if (isGroupword) count++;
		}
		System.out.println(count);
	}

}
