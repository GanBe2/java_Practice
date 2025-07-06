// 백준 10816 - 숫자 카드 2
// 숫자 카드 N개 중, M개의 숫자가 각각 몇 개 포함되어 있는지 출력
// 입력: 카드 N개의 숫자 목록, 조회할 숫자 M개
// 출력: 조회할 숫자에 대해 카드에 몇 개 포함되어 있는지
/*1번줄:카드갯수 n
2번줄:카드들을 띄어쓰기로 구분해서 삽입 n개
3번줄:m개의 질문이 들어올 것
4번줄:카드를 띄어쓰기로 구분해서 질문 m개
출력: 4번줄의 질문에 대해, 이 카드를 몇개 가지고 있는지 띄어쓰기로 구분*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekP10816 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>(); //카드번호, 등장횟수로 매핑.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = null;
		
		int n = Integer.parseInt(input.readLine()); //카드 몇개 들어올지 받아서 n에
		
		st = new StringTokenizer(input.readLine()); //readLine 으로 한줄읽어서 띄어쓰기로 구분하여 st에
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken()); //한 카드씩 정수로 바꿔서 카드번호변수 num에 넣음
			map.put(num, map.getOrDefault(num, 0)+1); //맵에 넣음
			/* getOrDefault(a,b)-> 
			 * 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
			 * 디폴트를 0으로 함. 없을 시 0+1. 등장횟수가 1이 됨
			 * 예를들어 등장횟수 2인 카드 num이 있다고 할 때, num을 키로 한 value를 출력할 수 있음
			 * 그럼 2가 get됨. 거기에 +1돼서 put. 등장횟수가 3이 되는 것*/
		}
		
		int m=Integer.parseInt(input.readLine()); //질문 갯수 m
		
		st = new StringTokenizer(input.readLine()); //한 줄 읽어서 띄어쓰기로 나누고 토큰으로 넣음
		
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			output.write(map.getOrDefault(num, 0)+" ");
		}
		output.flush();
		output.close();
		input.close();
	}
}
