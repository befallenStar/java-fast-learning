public class Test69{
	private static int mySqrt( int x ) {
		if (x == 1)
			return 1;
		for (long i = 0; i <= x>>1; i++) {
			if ((i * i) <= (long)x && (i + 1) * (i + 1) > (long)x)
				return (int)i;
			//System.out.println((i+1)*(i+1));
		}
		return 0;
	}

	public static void main( String[] args ){
		System.out.println(mySqrt(2147395600));
	}
}
