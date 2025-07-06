// 백준 1920 - 수 찾기
// 주어진 N개의 수 집합 A에 대해, M개의 수가 A에 포함되어 있는지 여부를 출력
// 입력: 정수 N개의 집합 A, 정수 M개의 조회 대상 숫자
// 출력: 각 조회 대상이 A에 있으면 1, 없으면 0 (각 줄에 출력)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekP1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();

		int length1 = Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine()); 

		for (int i = 0; i < length1; i++) {
		    set.add(Integer.parseInt(st.nextToken()));
		}

		int length2 = Integer.parseInt(input.readLine());
		st = new StringTokenizer(input.readLine()); 

		for (int i = 0; i < length2; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    System.out.println(set.contains(num) ? 1 : 0);
		}

	}

}
