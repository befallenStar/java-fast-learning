package sum;

import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		System.out.println(n.add(BigInteger.valueOf(1)).multiply(n).divide(BigInteger.valueOf(2)));
	}
}

