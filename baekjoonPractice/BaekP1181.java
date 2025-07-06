// 백준 1181 - 단어 정렬
// 길이가 짧은 단어부터, 길이가 같으면 사전 순으로 정렬
// 입력: 단어 N개 (중복 가능)
// 출력: 조건에 따라 정렬된 단어 목록 (중복 제거)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaekP1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		int length = Integer.parseInt(input.readLine());
		for (int i = 0; i < length; i++) {
			set.add(input.readLine());
		}
		List<String> list = new ArrayList<>(set);
		list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
		/*
		 * Comparator : 정렬 기준을 정의하는 인터페이스 
		 * comparingInt() : 정렬 기준을 정하는 메서드
		 *  숫자 기준으로 정렬할 때 사용. 
		 *  ex)comparingInt(String::length) 
		 *  ㄴ이건, String을 받아서 .length()순으로 정렬하는 Comparator 객체(정렬 기준)를 만든다는 것.
		 *  (그렇기 때문에 sort()안에 넣었을때 정렬로 작동하는것)
		 *  
		 * thencomparing() : 추가 정렬 기준을 정하는 메서드
		 *  첫째 정렬 기준이 같을 경우 이 기준으로 재비교 함.
		 */

		for (String string : list) {
			System.out.println(string);
		}
	}

}
