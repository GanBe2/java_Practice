// 백준 10814 - 나이순 정렬
// 회원 정보를 나이 오름차순으로 정렬하되, 나이가 같으면 가입 순서로
// 입력: 회원 수 N, 각 회원의 나이와 이름
// 출력: 나이순 정렬, 같을 시 가입 순서 정렬

import  java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BaekP10814 {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(input.readLine());
		
		List<Person> list=new ArrayList<>();
		
		for (int i = 0; i < length; i++) {
			StringTokenizer st=new StringTokenizer(input.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			list.add(new Person(age,name));
		}
		
		list.sort(Comparator.comparingInt(p->p.age));
		
		for (Person person : list) {
			System.out.println(person.age+" "+person.name);
		}
	}
	
	public static class Person{
		int age;
		String name;
		public Person(int age, String name) {
			this.age=age;
			this.name=name;
		}
		
	}
}
