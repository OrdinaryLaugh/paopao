package com.bjtc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 */
public class DateUtils {

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat webFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
    private static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
    /**
     * 将管理端发送的时间转换成String格式
     * @param time
     * @return
     */
    public static String webStringToString(String time) throws ParseException {
        Date parse = null;
        if(time!=null&&!time.equals("")) {
            parse = webFormat.parse(time);
        }
        String format = dayFormat.format(parse);
        Calendar calendar = Calendar.getInstance();
        parse = dayFormat.parse(format);
        calendar.setTime(parse);
        calendar.add(Calendar.DATE,1);
        parse = calendar.getTime();
        return dayFormat.format(parse);
    }

    /**
     * 获取本月第一天
     * @return
     */
    public static String getMonthFirstDay(Date currentDate){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH,0);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        //设置为1，指定本月第一天
        calendar.set(Calendar.DAY_OF_MONTH,1);
        String firstDay = simpleDateFormat.format(calendar.getTime());
        return firstDay;
    }

    /**
     * 获取本月最后一天
     * @return
     */
    public static String getMonthLastDay(Date currentDate){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        String lastDay = simpleDateFormat.format(calendar.getTime());
        return lastDay;
    }

    /**
     * 获取本周第一天（星期一）
     * @param currentDate
     * @return
     */
    public static String getWeekFirstDay(Date currentDate){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        String firstDay = simpleDateFormat.format(calendar.getTime());
        return firstDay;
    }

    /**
     * 获取本周最后一天（星期六）
     * @param currentDate
     * @return
     */
    public static String getWeekLastDay(Date currentDate){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        String lastDay = simpleDateFormat.format(calendar.getTime());
        return lastDay;
    }

    /**
     * 获取本年第一天
     * @param currentDay
     * @return
     */
    public static String getYearFirstDay(Date currentDay){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentDay);
        calendar.set(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        String firstDay = simpleDateFormat.format(calendar.getTime());
        return firstDay;
    }
    /**
     * 获取本年最后一天
     * @param currentDay
     * @return
     */
    public static String getYearLastDay(Date currentDay){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentDay);
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        String lastDay = simpleDateFormat.format(calendar.getTime());
        return lastDay;
    }

    /**
     * 返回本月的每一天
     * @param currentDay
     * @return
     */
    public static List<String> getMonthDays(Date currentDay){
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setTime(currentDay);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        List list = new ArrayList();
        int count = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i=1;i<=count;i++){
            list.add(dayFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH,+1);
        }
        return list;
    }
    /**
     * 返回本周的每一天
     * @param currentDay
     * @return
     */
    public static List<String> getWeekDays(Date currentDay){
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setTime(currentDay);
        calendar.set(Calendar.DAY_OF_WEEK,1);
        List list = new ArrayList();
        int count = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
        for(int i=1;i<=count;i++){
            list.add(dayFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_WEEK,+1);
        }
        return list;
    }
    /**
     * 返回本年的每一天
     * @param currentDay
     * @return
     */
    public static List<String> getYearDays(Date currentDay){
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setTime(currentDay);
        calendar.set(Calendar.DAY_OF_YEAR,1);
        List list = new ArrayList();
        int count = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        for(int i=1;i<=count;i++){
            list.add(dayFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR,+1);
        }
        return list;
    }

    /**
     * 将String转换成Date
     * @param stringList
     * @return
     * @throws ParseException
     */
    public static List<Date> convertStringToDate(List<String> stringList) throws ParseException {
        List<Date> dateList=new ArrayList<>();
        for(String day:stringList){
            Date date = simpleDateFormat.parse(day);
            dateList.add(date);
        }
        return dateList;
    }

    /**
     * 将Date转换成String
     * @param date
     * @return
     */
    public static String convertDateToString(Date date){
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 获取当前年份
     * @return
     */
    public static String getCurrentYear(){
        Date date = new Date();
        String format = yearFormat.format(date);
        return format;
    }
    /**
     * 获取当前年月
     * @return
     */
    public static String getCurrentMonth(){
        Date date = new Date();
        String format = monthFormat.format(date);
        return format;
    }

    /**
     * 获取传入日期的下一个月
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        return calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {
      /*  Date date = simpleDateFormat.parse("2019-04-13 00:00:00");
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);*/
//        String date = webStringToString("2019-05-10T16:00:00.000Z");
        Date date = new Date();
        System.out.println(date.after(getNextMonth(date)));
    }
}


