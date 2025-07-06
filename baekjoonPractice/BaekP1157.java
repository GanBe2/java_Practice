package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekP1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> map = new HashMap<>();
		int maxCount = 0;
		Character maxChar = '?';

		String word = input.readLine().toUpperCase();
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			int count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
			if (count > maxCount) {
				maxCount = count;
				maxChar = c;
			} else if (count == maxCount && c != maxChar) {
				maxChar = '?';
			}
		}
		System.out.println(maxChar);

	}

}
