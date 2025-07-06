package LevelPractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaekP11478 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				set.add(s.substring(i, j));
			}
		}
		System.out.println(set.size());
	}

}
