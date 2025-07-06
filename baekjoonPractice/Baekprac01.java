package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*다이얼을 돌리는데 걸리는 시간. 1부터 2,3,4,5,6,7,8,9,10,11
 *Hashmap 쓸건데, 이건 키값, 밸류 연결시키는 방식의 자료구조인듯
 *키값을 알파벳, 밸류를 시간으로 해서 매칭시키면 될듯 */

public class Baekprac01 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] groups = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < groups.length; i++) {
			String group = groups[i];
			for (int j = 0; j < group.length(); j++) {
				map.put(group.charAt(j), i + 3);
			}
		}
		int totalTime = 0;
		String word = input.readLine();
		for (int i = 0; i < word.length(); i++) {
			totalTime += map.get(word.charAt(i));
		}
		System.out.println(totalTime);
	}

}
