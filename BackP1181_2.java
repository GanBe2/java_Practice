package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

    길이가 짧은 것부터
    길이가 같으면 사전 순으로

단, 중복된 단어는 하나만 남기고 제거해야 한다.*/

public class BackP1181_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		/* 중복검사를 위해 set에 먼저 넣음. */
		int length = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < length; i++) 
			set.add(input.readLine());
		
		List<String> list = new ArrayList<>(set);
		/* list 생성할때 set 넣을수있음 */
		
		list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
		
		/*
		 * Comparator : 정렬 기준을 정의하는 인터페이스 
		 * comparingInt() : 정렬 기준을 정하는 메서드
		 *  숫자 기준으로 정렬할 때 사용. 
		 *  ex)comparingInt(String::length) 
		 *  ㄴ이건, String을 받아서 .length()순으로 정렬하는 Comparator 객체(정렬 기준)를 만든다는 것.
		 *  (그니까 sort()안에 넣었을때 정렬로 작동하는거지.
		 *  
		 * thencomparing() : 추가 정렬 기준을 정하는 메서드
		 *  첫째 정렬 기준이 같을 경우 이 기준으로 재비교 함.
		 */
		
		for (String s:list) {
			System.out.println(s);
		}

	}

}
