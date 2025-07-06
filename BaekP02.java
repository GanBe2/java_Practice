package LevelPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekP02 {

	public static void main(String[] args) throws IOException{
		BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*입력이 끝날때까지 그대로 출력을 반복한다. 그러면 while해서 has어쩌구로 계속 입력 있을때까지 반복하면 될듯*/
		String line;
		while ((line = input.readLine())!=null) {
			output.write(line);
			output.newLine();
		}
		
		output.flush();
		output.close();
		input.close();
	}

}
