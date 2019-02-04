import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDemo{
	public static void main(String[] args){
		System.out.println("默认格式输出当前时间。");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		System.out.println(sdf.format(date));
		//yyyy：年	MM：月	dd：日	E：星期几
		//hh：1~12小时制(1-12)	HH：24小时制(0-23)	mm：分	ss：秒	S：毫秒
		//	D：一年中的第几天
		//	F：一月中的第几个星期(会把这个月总共过的天数除以7)
		//	w：一年中的第几个星期
		//	W：一月中的第几星期(会根据实际情况来算)
		//	a：上下午标识
		//	k：和HH差不多，表示一天24小时制(1-24)
		//	K：和hh差不多，表示一天12小时制(0-11)
		//	z：表示时区
		System.out.println("通过calendar类获取当前时间：\n" +
				"getTime获得默认格式的当前时间。\n" +
				"通过get方法获得各项详细信息。");
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println("今天是"+cal.get(Calendar.YEAR)+"年"+ (cal.get(Calendar.MONTH)+1) +"月"+cal.get(Calendar.DATE)+"日");
		//get(Calendar.MONTH)+1为当前月份
		System.out.println("这是今年的第"+cal.get(Calendar.DAY_OF_YEAR)+"天");
		System.out.println("是这个月的第"+cal.get(Calendar.DAY_OF_MONTH)+"天");
		System.out.println("是这个礼拜的第"+cal.get(Calendar.DAY_OF_WEEK)+"天（默认以周日为第一天）");
		//可以通过setFirstDayOfWeek修改
		System.out.println("现在是"+cal.get(Calendar.HOUR_OF_DAY)+"时"+cal.get(Calendar.MINUTE)+"分"+cal.get(Calendar.SECOND)+"秒"+cal.get(Calendar.MILLISECOND)+"毫秒");
		//get(Calendar.HOUR):1-12,get(Calendar.HOUR_OF_DAY):0-23
		//calendar还有很多详细的参数
		System.out.println("获取时间戳：\n" +
				"通过system.currentTimeMillis方法获得时间戳，类型Long。");
		Long timeStamp=System.currentTimeMillis();
		System.out.println(sdf.format(timeStamp));
	}
}
