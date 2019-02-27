package xiaonei3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		LinkedList<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++)
			q.add(sc.nextInt());
		int sum = 0;
		int result = 0;
		int record;
		for(int j = 0; j < n; j++){
			record = 0;
			for(int i = 1; i < n + 1; i++){
				if((i - record) % n == q.get((i + j - 1) % n)){
					sum += (i - record) % n;
					record = i;
				}
			}
			result = sum > result ? sum : result;
		}
		System.out.println(result);
	}
}
