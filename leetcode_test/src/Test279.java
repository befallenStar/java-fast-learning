import java.util.Scanner;

public class Test279{
	private static int numSquares(int n){
		if(n < 4)
			return n;
		int[] tmps = new int[n + 1];
		for(int i = 0; i < 4; i++)
			tmps[i] = i;
		for(int i = 4; i <= n; i++){
			int tmp = n;
			for(int j = 2; j * j <= i; j++){
				tmp = Math.min(tmp, tmps[i - j * j] + 1);
			}
			tmps[i] = tmp;
		}
		return tmps[n];
	}

	public static void main(String[] args){
		System.out.println(numSquares(new Scanner(System.in).nextInt()));
	}
}
