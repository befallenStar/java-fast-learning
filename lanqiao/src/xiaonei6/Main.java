package xiaonei6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] code = new int[n];
		for(int i = 0; i < n; i++)
			code[i] = sc.nextInt();
		ArrayList<Integer> sk = new ArrayList<>();
		int result = 0;
		for(int k = 0; k < n; k++){
			int index = code[k];
			while(sk.indexOf(index) < 0){
				sk.add(index);
				index = code[index - 1];
			}
			result = result > sk.size() ? result : sk.size();
			sk.clear();
		}
		System.out.println(result);
	}
}
