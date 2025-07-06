package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*hashset 안에 넣음. 
띄어쓰기를 기준으로 이름과 액션을 분리함. 
액션을 판단해서 추가할지 삭제할지 정함.
정렬방법이 들어있는 클래스인 Collections를 사용함.*/

public class BaekP7785 {

	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hash = new HashSet<>();
		
		int length = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < length; i++) {
			String[] words = input.readLine().split(" ");
			String name = words[0];
			String action = words[1];
			if (action.equals("enter")) hash.add(name);
			else hash.remove(name);
		}
		
		ArrayList<String> arr = new ArrayList<>(hash);
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < arr.size(); i++) {
			String name = arr.get(i);
			System.out.println(name);
		}
		
	}

}
