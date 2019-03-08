import java.util.Arrays;
import java.util.Collections;

public class Test406{
	private static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,(o1, o2)->(o2[0]-o1[0])!=0?(o2[0]-o1[0]):(o1[1]-o2[1]));
		for(int i=0;i<people.length;i++){
			if(i!=people[i][1])
				insertElement(people, i, people[i][1]);
		}
		return people;
	}
	private static void insertElement(int[][] o, int key, int index){
		int[] ele=o[key];
		//System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(o, index, o, index+1, key-index);
		o[index]=ele;
	}
	public static void main(String[] args){
		int[][] people={{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
		people=reconstructQueue(people);
		for(int[] p : people)
		System.out.println(p[0]+" "+p[1]);
	}
}
