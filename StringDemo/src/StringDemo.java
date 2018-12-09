import java.util.StringTokenizer;

public class StringDemo {
    public static void main(String[] args){
        String str="Hello World";
        String anotherStr="hello world";
        String longStr="Hello World and Good Morning";
        String mainStr="abcaaabbbcccaabbccabc";
        String subStr="abc";
        String[] splitStr;
        System.out.println("比较字符串：\n" +
                "两个字符数组依次从前开始比较，如果对象位置出现字符不同则返回两个字符的编码之差，后面的字符不再比较；\n" +
                "如果两个字符数组的长度不一样，并且较短的数组和较长数组所有对应位置的字符都相同，则返回两个数组的长度之差。\n" +
                "compareTo直接比较字符串；\n" +
                "compareToIgnoreCase忽视大小写比较字符串。");
        System.out.println("str=\"Hello World\", anotherStr=\"hello world\", longStr=\"Hello World and Good Morning\"");
        System.out.println(str.compareTo(anotherStr)+"=ASCII(H) - ASCII(h)");
        System.out.println(str.compareTo(longStr)+"=str.length - longStr.length");
        System.out.println(longStr.compareTo(str)+"=longStr.length - str.length");
        System.out.println(str.compareToIgnoreCase(anotherStr));
        System.out.println(anotherStr.compareToIgnoreCase(longStr));
        System.out.println("查找子串：\n" +
                "indexOf返回子串第一次出现的位置；\n" +
                "lastIndexOf返回子串最后一次出现的位置。");
        System.out.println("mainStr=\"abcaaabbbcccaabbccabc\", subStr=\"abc\"");
        System.out.println(mainStr.indexOf(subStr));
        System.out.println(mainStr.lastIndexOf(subStr));
        System.out.println("获取子串：\n" +
                "定义开始位置；\n" +
                "结束位置可定义或为主串结尾。");
        System.out.println(str.substring(0,str.length()/2));
        System.out.println("替换：\n" +
                "返回目标字符串而不改变原字符串" +
                "\nreplace替换所有符合条件的字符；\n" +
                "replaceFirst替换第一个符合条件的字符串；\n" +
                "replaceAll替换所有符合条件的字符串。");
        System.out.println(mainStr.replace('a','d'));
        System.out.println(mainStr.replaceFirst("abc","def"));
        System.out.println(mainStr.replaceAll("abc","ghi"));
        System.out.println("反转：\n" +
                "用stringbuffer实现字符串反转");
        System.out.println(new StringBuffer(str).reverse().toString());
        System.out.println("查找：\n" +
                "indexOf返回子串在主串中第一次出现的位置。");
        System.out.println(mainStr.indexOf(subStr));
        System.out.println("分割：\n" +
                "split参数为字符串，以字符串为界分割主串并返回字符串数组。");
        splitStr=longStr.split(" ");
        //for each对数组成员进行遍历
        //for(Type name:array)
        for(String x:splitStr)  //for(int i=0;i<splitStr.length;i++)
            System.out.println(x);  //System.out.println(splitStr[i]);
        System.out.println("实例化StringTokenizer对主串进行分割，默认为空格、制表符、换行符、回车符。");
        StringTokenizer st1=new StringTokenizer(longStr);
        while(st1.hasMoreTokens())  //返回是否还有分隔符
            System.out.println(st1.nextToken());    //返回下一个子串
        StringTokenizer st2=new StringTokenizer(mainStr,"ab");
        System.out.println("StringTokenizer和split方法还有一个很重要的区别就是：（在分割字符串不止一个字符的情况下）前者会以给定分割字符串的每个字符进行分割，而后者是以整个字符串进行切割。");
        System.out.println("StringTokenizer");
        while(st2.hasMoreElements())    //返回是否还有分隔符
            System.out.println(st2.nextElement());  //返回下一个分割元素
        System.out.println("split");
        splitStr=mainStr.split("ab");
        for(String x:splitStr)
            System.out.println(x);
        System.out.println("大小写转换：\n" +
                "toUpperCase全部转换为大写；\n" +
                "toLowerCase全部转换为小写。");
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println("区域比较：\n" +
                "regionMatches对两个字符串指定位置、长度内的字符进行比较");
        System.out.println(str.regionMatches(6,anotherStr,6,5));
        System.out.println(str.regionMatches(true,6,anotherStr,6,5));
        System.out.println("连接：\n" +
                "StringBuilder.append对字符串进行连接，最佳。\n" +
                "其他方法：\n" +
                "直接用+运算符；concat方法；StringUtils.join对字符串数组进行连接；StringBuffer.append方法进行连接。");
        StringBuilder sb=new StringBuilder(str);
        System.out.println(sb.append(anotherStr).toString());
    }
}
