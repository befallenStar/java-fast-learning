import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDemo{
	public static void main(String[] args){
		System.out.println("默认格式输出当前时间。");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		System.out.println(sdf.format(date));
	}
}
