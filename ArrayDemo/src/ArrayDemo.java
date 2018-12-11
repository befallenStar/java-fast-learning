import javax.annotation.PostConstruct;
import java.util.*;

public class ArrayDemo {
    public static void main(String[] args){
        Integer[] data={12,-1,23,32,3,-5,2,0,-19,47,56,86,-95};
        System.out.println("原数组：{12,-1,23,32,3,-5,2,0,-19,47,56,86,-95}");
        System.out.println("排序：\n" +
                "sort按升序顺序进行排序。排序完的结果覆盖到原数组当中去。");
        Arrays.sort(data);
        printArray(data);
        System.out.println("通过重载Comparator借口实现不同类型数据排序或降序排序。");
        Comparator cmp=new MyComparator();
        Arrays.sort(data,cmp);
        printArray(data);
        System.out.println("查找：\n" +
                "binarySearch查找元素在数组当中的位置，没查到返回负数。\n" +
                "采用二分查找，所以对原数组有要求，采取默认升序排序。");
        Arrays.sort(data);
        System.out.println(Arrays.binarySearch(data,2));
        System.out.println(Arrays.binarySearch(data,10));
        System.out.println("插入：\n" +
                "调用系统函数arrayCopy实现部分数组的拷贝，并实现插入操作。");
        data=insertElement(data,5,7);
        printArray(data);
        System.out.println("翻转：\n" +
                "先将数组转换成list，然后通过Collections.reverse对list实现翻转。" +
                "System.out.println对list直接输出，收在方括号里面，以逗号隔开每个元素。");
        List<Integer> dataList=new ArrayList<>(Arrays.asList(data));
        System.out.println(dataList);
        Collections.reverse(dataList);
        System.out.println(dataList);
        System.out.println("最值：\n" +
                "通过Collections.max/min对list对象进行取最值操作。");
        System.out.println(Collections.max(dataList));
        System.out.println(Collections.min(dataList));
        Integer[] newData={123,-234,342,-345};
        List<Integer> newDataList=new ArrayList<>(Arrays.asList(newData));
        dataList.addAll(newDataList);
        System.out.println(dataList);
        System.out.println("填充：\n" +
                "fill将数组索引之内（[fromIndex,toIndex)）的值填充为目标值。");
        Arrays.fill(newData,1,3,200);
        printArray(newData);
    }
    public static void printArray(Integer[] data){
        for(int x:data) //或者用迭代器进行循环    for(Iterator<Integer> iterator=data.iterator();iterator.hasNext();iterator.next())
            System.out.print(String.valueOf(x)+' ');
        System.out.println();
    }
    static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    }
    public static Integer[] insertElement(Integer[] o,Integer key,int index){
        Integer[] destination = new Integer[o.length+1];
        System.arraycopy(o,0,destination,0,index);
        destination[index]=key;
        System.arraycopy(o,index,destination,index+1,o.length-index);
        return destination;
    }
}
