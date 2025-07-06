package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*hashset으로중복인지먼저보고중복이면넘기고중복아니면set안에있는지확인하고있으면그룹숫자아님*/

public class BaekP1316_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;

		int length = Integer.parseInt(input.readLine());

		for (int i = 0; i < length; i++) {// 단어 하나씩 읽는 반복문
			Set<Character> set = new HashSet<>();
			String word = input.readLine();
			char pre = word.charAt(0);
			boolean isGroup = true;
			set.add(pre);
			for (int j = 1; j < word.length(); j++) {// 알파벳 하나씩 읽는 반복문
				char now = word.charAt(j);
				// 만약 두 글자가 다르고, set 안에 있을 시 그룹글자 박탈
				if (pre != now) {
					if (set.contains(now)) {
						isGroup = false;
						break;
					}
					set.add(now);
				}
				pre=now;
			}
			if (isGroup == true)
				count++;
		}
		System.out.println(count);
	}

}
