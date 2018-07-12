/**
 * @file: SqlDateUtil.java
 * @description: 日期操作工具类
 * @version： 1.0
 */
package com.velvol.hr.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIEMSTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间字符串 格式：yyyy-MM-dd
     *
     * @return String
     */
    public static String currentDateString() {
        return currentDateString(DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取指定格式的字符串
     *
     * @return String
     */
    public static String currentDateString(String pattern) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String result = simpleFormat
                .format(new Date(System.currentTimeMillis()));
        return result;
    }

    /**
     * 获取当前日期
     *
     * @return Date
     */
    public static Date currentDate() {
        return new Date(System.currentTimeMillis());
    }



    /**
     * 解析日期
     *
     * @param dateStr
     *            :日期字符串
     * @param pattern
     *            :指定模式
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr, String pattern)
            throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        Date date = new Date(simpleFormat.parse(dateStr).getTime());
        return date;
    }

    /**
     * 获取当前时间戳字符串
     *
     * @return String
     */
    public static String currentTimestampString() {
        return currentTimestampString(DEFAULT_TIEMSTAMP_PATTERN);
    }

    /**
     * 根据指定的日期模板获取当前Timestamp字符串
     *
     * @return String
     */
    public static String currentTimestampString(String pattern) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String result = simpleFormat.format(new Timestamp(System
                .currentTimeMillis()));
        return result;
    }

    /**
     * 格式化Timestamp为指定的模板的字符串
     *
     * @param timestamp
     *            :时间戳对象
     * @param pattern
     *            :指定模式
     * @return String
     */
    public static String formatTimestamp(Timestamp timestamp, String pattern) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String result = simpleFormat.format(timestamp);
        return result;
    }

    /**
     * 格式化Timestamp为默认模板的字符串
     *
     * @param timestamp
     *            :时间戳对象
     * @return String
     */
    public static String formatTimestamp(Timestamp timestamp) {
        return formatTimestamp(timestamp, DEFAULT_DATE_PATTERN);
    }

    /**
     * 格式化Date为指定的模板的字符串
     *
     * @param date
     *            :日期对象
     * @param pattern
     *            :模式
     * @return String
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String result = simpleFormat.format(date);
        return result;
    }

    /**
     * 格式化Date为默认模板的字符串
     *
     * @param date
     *            ：日期对象
     * @return String
     */
    public static String formatDate(Date date) {
        return formatDate(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * 得到当前时间的Timestamp对象
     *
     * @return Timestamp
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }




    /**
     * 得到当前系统年
     *
     * @return: String
     */
    public static String getYear() {
        Calendar c = Calendar.getInstance();
        return Integer.toString(c.get(Calendar.YEAR));
    }

    /**
     * 得到当前系统月
     *
     * @return: String
     */
    public static String getMonth() {
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.MONTH) + 1;
        String s = null;
        if (i < 10) {
            s = "0" + String.valueOf(i);
        } else {
            s = String.valueOf(i);
        }
        return s;
    }

    /**
     * 得到当前系统日
     *
     * @return: String
     */
    public static String getDay() {
        Calendar c = Calendar.getInstance();
        return Integer.toString(c.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 得到当前系统日期
     *
     * @return: String
     */
    public static String getDate() {
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance();
        return df.format(c.getTime());
    }

    /**
     * 得到当前系统日期和时间
     *
     * @return: String
     */
    public static String getDateTime() {
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateTimeInstance();
        return df.format(c.getTime());
    }

    /**
     * 得到当前系统时间
     *
     * @return: String
     */
    public static String getTime() {
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getTimeInstance();
        return df.format(c.getTime());
    }

    // //-----------------------新增加的方法--------------------------
    public static final String[] DATE_PATTERN = { "y", "M", "d", "H", "m", "s",
            "S" };

    /**
     * 返回当前时间
     *
     * @return java.sql.Date
     */
    public static Date getSqlDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 返回当前时间
     *
     * @return java.util.Date
     */
    public static java.util.Date getUtilDate() {
        return new java.util.Date(System.currentTimeMillis());
    }

    /**
     * 给一个日期加几天/或减几天
     *
     * @param date
     *            -1表示减一天，1表示加一天，以此类推。
     */
    public static void addDay(java.util.Date date, int day) {
        date.setTime(date.getTime() + day * 24 * 60 * 60 * 1000l);
    }

    /**
     * 给一个日期加/减多少小时
     *
     * @param date
     * @param hour
     */
    public static void addHour(java.util.Date date, int hour) {
        date.setTime(date.getTime() + hour * 60 * 60 * 1000l);
    }

    /**
     * 给一个日期加/减多少分钟
     *
     * @param date
     * @param minute
     */
    public static void addMinute(java.util.Date date, int minute) {
        date.setTime(date.getTime() + minute * 60 * 1000l);
    }

    /**
     * 给一个日期加/减多少秒
     *
     * @param date
     * @param second
     */
    public static void addSecond(java.util.Date date, int second) {
        date.setTime(date.getTime() + second * 1000l);
    }

    /**
     * 给一个日期加/多少月
     *
     * @param date
     * @param month
     */
    public static void addMonth(java.util.Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        date.setTime(c.getTime().getTime());
    }

    /**
     * 给一个日期加/多少年
     *
     * @param date
     * @param year
     */
    public static void addYear(java.util.Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        date.setTime(c.getTime().getTime());
    }

    /**
     * 根据给定的数字和格式代表的时间偏移量，获得以毫秒为单位的偏移量 <br>
     * <b>例如：2d代表2天，得到2*24*60*60*1000毫秒</b>
     *
     * @param d_end
     *            Date 要加的日期
     * @param timeNum
     *            int 时间的数字部分
     * @param pattern
     *            String 时间的单位(天、分钟等)
     * @return Date 加上一定时间的日期
     */
    public static Date addVeryDate(java.util.Date d_end, int timeNum,
                                   char pattern) {
        Date d = new Date(d_end.getTime());
        switch (pattern) {
            case 'y':// 年
                addYear(d, timeNum);
                break;
            case 'M':// 月
                addMonth(d, timeNum);
                break;
            case 'd':// 日
                addDay(d, timeNum);
                break;
            case 'H':// 时
                addHour(d, timeNum);
                break;
            case 'm':// 分钟
                addMinute(d, timeNum);
                break;
            case 's':// 秒
                addSecond(d, timeNum);
                break;
        }
        return d;
    }

    /**
     * 将字符串解析为java.util.Date
     *
     * @param dateStr
     *            String
     * @return Date
     */
    public static java.util.Date parseToUtilDate(String dateStr) {
        return parseToUtilDate(dateStr, getDatePattern(dateStr));
    }

    /**
     * 将字符串解析为java.util.Date
     *
     * @param dateStr
     *            String
     * @param datePattern
     *            String
     * @return Date
     */
    public static java.util.Date parseToUtilDate(String dateStr,
                                                 String datePattern) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(datePattern);
        try {
            return simpleFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将时间戳转换为时间
     */
    public static java.util.Date stampToDate(Long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //long lt = new Long(s);
        //Date date = new Date(lt);
        res = simpleDateFormat.format(s);
        try {
            return simpleDateFormat.parse(res);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将字符串解析为java.sql.Date
     *
     * @param dateStr
     *            String
     * @return Date
     */
    public static Date parseToSQLDate(String dateStr) {
        return (new Date(parseToUtilDate(dateStr).getTime()));
    }

    /**
     * 将字符串解析为java.sql.Date
     *
     * @param dateStr
     * @param datePattern
     * @return
     */
    public static Date parseToSQLDate(String dateStr,
                                               String datePattern) {
        return (new Date(parseToUtilDate(dateStr, datePattern)
                .getTime()));
    }

    /**
     * 将字符串解析为java.sql.Timestamp
     *
     * @param dateStr
     *            String
     * @return Timestamp
     */
    public static Timestamp parseToTimestamp(String dateStr) {
        return new Timestamp(parseToSQLDate(dateStr).getTime());
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDate(Object date) {
        if(date==null){
            return DateUtil.currentDateString();
        }else{
            return formatDate(date, "yyyy-MM-dd");
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Object date, String format) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        return simpleFormat.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDateTime(Object date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Object date, String format) {
        return formatDate(date, format);
    }

    /**
     *
     * @return
     */
    public static Timestamp getSqlTimestamp() {
        return new Timestamp(getSqlDate().getTime());
    }

    /**
     * 解析日期格式
     *
     * @param dateString
     * @return
     */
    private static String getDatePattern(final String dateString) {
        String temp = dateString;
        Pattern regexPattern = Pattern.compile("(\\d+)([\\D]{1})(.+)");
        Matcher m = regexPattern.matcher(temp);
        StringBuffer sb = new StringBuffer();
        int j = 0;
        while (m.matches()) {
            sb.append(m.group(1).replaceAll("\\d{1}", DATE_PATTERN[j++]));
            sb.append(m.group(2));
            temp = m.group(3);
            m = regexPattern.matcher(temp);
        }
        sb.append(temp.replaceAll("\\d{1}", DATE_PATTERN[j++]));
        return sb.toString();
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static java.util.Date format2Date(java.util.Date date, String format) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        try {
            return simpleFormat.parse(simpleFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 两日期之间的天数
    public static long getQuot(String time1, String time2) throws ParseException{
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = ft.parse(time1);
        java.util.Date date2 = ft.parse(time2);
        quot = date1.getTime() - date2.getTime();
        quot = quot / 1000 / 60 / 60 / 24;
        return quot;
    }
    // 两日期之间的天数
    public static long getQuot(java.util.Date startDate, java.util.Date endDate) throws ParseException{
        long quot = 0;
        quot = startDate.getTime() - endDate.getTime();
        quot = quot / 1000 / 60 / 60 / 24;
        return quot;
    }


    public static String  getDateRandom(){
        String dateRandom= formatTimestamp(new Timestamp(System.currentTimeMillis()),"yyyyMMddHHmmssSSS");
        return dateRandom;
    }

    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN_FORMAT = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String format(java.util.Date date) {
        return format(date, DATE_PATTERN_FORMAT);
    }

    public static String format(java.util.Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 取得当前日期所在周的第一天  （该方法从星期一开始）
     *
     * @param date
     * @return
     */
    public static java.util.Date getFirstDayOfWeek(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static java.util.Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @return
     */
    public static java.util.Date getFirstDayOfMonth(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @return
     */
    public static java.util.Date getLastDayOfMonth(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * @desc 获取当前时间的每周天时间
     * @param date
     * @return
     */
    public static Map<String, Object> getWeek(java.util.Date date) {
        Map<String, Object> map = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//从周一开始第一天
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        map.put("monday", df.format(cal.getTime()));
        // 获取本周日的日期
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+6);
        map.put("sunday", df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+1);
        map.put("tuesday", df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+2);
        map.put("wednesday", df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+3);
        map.put("thursday", df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+4);
        map.put("friday", df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+5);
        map.put("saturday", df.format(cal.getTime()));
        return map;
    }

    /**
     * 获取时间段内所有的年月集合
     *
     * @param minDate 最小时间  2017-01
     * @param maxDate 最大时间 2017-10
     * @return 日期集合 格式为 年-月
     * @throws Exception
     */
    public static Map<String, Object> getMonthBetween(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Map<String, Object> map = new HashMap<>();
        Calendar curr = min;
        int index = 1;
        while (curr.before(max)) {
            String date = sdf.format(curr.getTime());
            map.put("date"+ index++, date);
            //result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return map;
    }

    public static void main(String [] ares) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");//格式化为2017-10
        Calendar calendar = Calendar.getInstance();//得到Calendar实例
        calendar.add(Calendar.MONTH, -5);//把月份减三个月
        java.util.Date starDate = calendar.getTime();//得到时间赋给Data
        String stardtr = formatter.format(starDate);//使用格式化Data
        Map<String, Object> map =  getMonthBetween(stardtr, "2018-07-10");

        System.out.print(map);
    }
}
