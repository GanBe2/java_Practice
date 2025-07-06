package LevelPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BakkP2750 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int length=Integer.parseInt(input.readLine());
		for (int i = 0; i < length; i++) {
			list.add(Integer.parseInt(input.readLine()));
		}
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

}
