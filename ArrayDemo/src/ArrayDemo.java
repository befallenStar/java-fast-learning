import java.util.*;

public class ArrayDemo{
	public static void main(String[] args){
		Integer[] data = {12, - 1, 23, 32, 3, - 5, 2, 0, - 19, 47, 56, 86, - 95};
		System.out.println("原数组：{12,-1,23,32,3,-5,2,0,-19,47,56,86,-95}");
		System.out.println("排序：\n" +
				"sort按升序顺序进行排序。排序完的结果覆盖到原数组当中去。");
		Arrays.sort(data);
		printArray(data);
		System.out.println("通过重载Comparator接口实现不同类型数据排序或降序排序。");
		Comparator cmp = new MyComparator();
		Arrays.sort(data, cmp);
		printArray(data);
		System.out.println("查找：\n" +
				"binarySearch查找元素在数组当中的位置，没查到返回负数。\n" +
				"采用二分查找，所以对原数组有要求，采取默认升序排序。");
		Arrays.sort(data);
		System.out.println(Arrays.binarySearch(data, 2));
		System.out.println(Arrays.binarySearch(data, 10));
		System.out.println("插入：\n" +
				"调用系统函数arrayCopy实现部分数组的拷贝，并实现插入操作。");
		data = insertElement(data, 5, 7);
		printArray(data);
		System.out.println("翻转：\n" +
				"先将数组转换成list，然后通过Collections.reverse对list实现翻转。\n" +
				"System.out.println对list直接输出，收在方括号里面，以逗号隔开每个元素。");
		List<Integer> dataList = new ArrayList<>(Arrays.asList(data));
		System.out.println(dataList);
		Collections.reverse(dataList);
		System.out.println(dataList);
		System.out.println("最值：\n" +
				"通过Collections.max/min对list对象进行取最值操作。");
		System.out.println(Collections.max(dataList));
		System.out.println(Collections.min(dataList));
		Integer[] newData = {123, - 234, 342, - 345};
		List<Integer> newDataList = new ArrayList<>(Arrays.asList(newData));
		dataList.addAll(newDataList);
		System.out.println(dataList);
		System.out.println("填充：\n" +
				"fill将数组索引之内（[fromIndex,toIndex)）的值填充为目标值。");
		Arrays.fill(newData, 1, 3, 200);
		printArray(newData);
		System.out.println("添加删除：\n" +
				"add在list对象末尾添加元素 或在指定位置添加元素。\n" +
				"remove删除list对象对应位置元素，或根据元素值删除。");
		System.out.println(dataList);
		dataList.add(100);
		dataList.add(1, 200);
		System.out.println(dataList);
		dataList.remove(1); //return 1
		dataList.remove((Integer) 100);	//return true because it has 100
		dataList.remove((Integer) 1000);	//return false because it doesn't have 1000
		System.out.println(dataList);
		System.out.println("集合运算：\n" +
				"交集：调用retainAll方法，保留与被比较list相同元素。\n" +
				"差集：调用removeAll方法，删除与被比较list相同元素。\n" +
				"并集：利用set元素不重复的特性，将两个list存进同一个set中来达到求并集的目的。");
		newDataList.retainAll(dataList);
		System.out.println(newDataList);
		dataList.removeAll(newDataList);
		System.out.println(dataList);
		printUnion(dataList,newDataList);
		System.out.println("查找：\n" +
				"调用contains方法根据元素值查找是否存在。\n" +
				"调用containsAll方法查找是否为自己子集。");
		System.out.println("dataList.contains(100): "+dataList.contains(100));
		System.out.println("dataList.containsAll(newDataList): "+dataList.containsAll(newDataList));
		System.out.println("list进行比较：\n" +
				"调用equals方法对两个list对象进行比较，当每组对应（即与顺序有关）元素值均相等时才返回true。");
		List<Integer> anotherList=new ArrayList<>(newDataList);
		System.out.println(anotherList);
		System.out.println(newDataList.equals(anotherList));
		anotherList.sort(cmp);
		System.out.println(anotherList);
		System.out.println(newDataList.equals(anotherList));
	}

	private static void printUnion(List<Integer> dataList, List<Integer> newDataList){
		Set<Integer> dataSet = new HashSet<>(dataList);
		dataSet.addAll(newDataList);
		System.out.println(dataSet);
	}

	private static void printArray(Integer[] data){
		for(int x : data) //或者用迭代器进行循环    for(Iterator<Integer> iterator=data.iterator();iterator.hasNext();iterator.next())
			System.out.print(String.valueOf(x) + ' ');
		System.out.println();
	}

	static class MyComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer i1, Integer i2){
			return i2 - i1;
		}
	}

	private static Integer[] insertElement(Integer[] o, Integer key, int index){
		Integer[] destination = new Integer[o.length + 1];
		System.arraycopy(o, 0, destination, 0, index);
		destination[index] = key;
		System.arraycopy(o, index, destination, index + 1, o.length - index);
		return destination;
	}
}
