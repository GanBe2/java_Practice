package LevelPractice;

import java.util.Iterator;
import java.util.Scanner;

public class BaekP2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] croatian= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String word =sc.nextLine();
		for (String c : croatian) {
			word=word.replace(c, "*");
		}
		System.out.println(word.length());
	}

}
