package cn.com.utils;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: code
 * @description: 时间处理类
 * @author: Lillie
 * @create: 2018-05-18 10:53
 **/
@Component
public class DateUtil {
    private DateUtil() {
    }

    private static final String DEFAULT_TIME = "1970-01-01 00:00:00";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT_DD = "yyyy-MM-dd";
    private static final String DATE_FORMAT2 = "yyyy/MM/dd HH:mm:ss";
    private static final String DATE_FORMATSS = "yyyy-MM-dd HH:mm:ss:SSS";
    private static final String DATE_FORMATY = "yyMMdd";
    private static final String DATE_FORMATM = "yyyyMM";
    private static final String DATE_FORMATHS = "HHmmss";
    private static final String DATE_FORMATHMS = "HH:mm:ss";
    private static final String DATE_FORMAT_MM = "yyyy-MM";
    private static final String DATE_FORMATSSS = "yyyyMMddHHmmssSSS";

    private static final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

    @ApiModelProperty(value = "获取自1970-1-1 00:00:00 到现在的秒数")
    public static Long getCurSeconds() {
        //获取毫秒数
        Long curTime = System.currentTimeMillis();
        //获取秒数
        long totalSeconds = curTime / 1000;
        return totalSeconds;
    }

    @ApiModelProperty(value = "获取当前日期  格式为 yyyy-MM-dd HH:mm:ss SSS")
    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATSS);
        return sdf.format(new Date());
    }


    @ApiModelProperty(value = "获取当前日期  格式为 yyyyMMdd")
    public static String getyyyyMMdd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    @ApiModelProperty(value = "获取当前时间 格式为 yyyy-MM-dd HH:mm:ss")
    public String getCurTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }


    public static String getDateStr(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMAT).format(date);
        return dateStr;
    }


    private static final Logger logger = Logger.getLogger(DateUtil.class);

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocalss = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMATSS);
        }
    };

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocaldd = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_DD);
        }
    };

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocal2 = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT2);
        }
    };

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocalHMS = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMATHMS);
        }
    };
    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocalMM = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_MM);
        }
    };

    public static DateFormat getDateFormatSS() {
        return (DateFormat) threadLocalss.get();
    }

    public static DateFormat getDateFormat() {
        return (DateFormat) threadLocal.get();
    }

    public static DateFormat getDateFormat2() {
        return (DateFormat) threadLocal2.get();
    }

    public static DateFormat getDateFormatDD() {
        return (DateFormat) threadLocaldd.get();
    }

    public static DateFormat getDateFormatHMS() {
        return (DateFormat) threadLocalHMS.get();
    }

    public static DateFormat getDateFormatMM() {
        return (DateFormat) threadLocalMM.get();
    }

    /**
     * @param t
     * @return 格式化时间
     */
    public static Date fromatDates(Date t) {
        try {
            String timeDate = getDateFormat().format(t);
            return DateUtil.getString2Date(timeDate);
        } catch (Exception e) {
            logger.error("fromatDates出错。", e);
            return null;
        }

    }

    public static String formateDate3(Date t) {
        try {
            return getDateFormat2().format(t);
        } catch (Exception e) {
            logger.error("formateDate3出错", e);
            return null;
        }
    }

    /**
     * <p>Title: getString2DateYY<／p>
     * <p>Description: YYYYMMddHH24MISS转换成java.util.Date<／p>
     *
     * @param strDate
     * @return
     */
    public static Date getString2DateYY(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                String year = strDate.substring(0, 4);
                String month = strDate.substring(4, 6);
                String day = strDate.substring(6, 8);
                String hour = strDate.substring(8, 10);
                String min = strDate.substring(10, 12);
                String sec = strDate.substring(12, 14);
                String str = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
                date = getString2Date(str);
            } catch (Exception e) {
                logger.error("getString2DateYY出错。", e);
            }
        }
        return date;
    }

    /**
     * @param t
     * @return 格式化时间为yyyy-mm-dd
     */
    public static Date fromatDatesDD(Date t) {

        try {
            String timeDate = getDateFormatDD().format(t);
            return DateUtil.getString2DateDD(timeDate);
        } catch (Exception e) {
            logger.error("fromatDatesDD出错。", e);
            return null;
        }
    }

    /**
     * @param t
     * @return 格式化时间为yyyy-MM
     */
    public static Date fromatDatesMM(Date t) {

        try {
            String timeDate = getDateFormatMM().format(t);
            return DateUtil.getString2DateMM(timeDate);
        } catch (Exception e) {
            logger.error("fromatDatesMM出错。", e);
            return null;
        }

    }

    /**
     * 将字符串日期yyyy-MM-dd HH:mm:ss转换为java.util.Date
     *
     * @param strDate
     * @return
     */
    public final static Date getString2Date(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormat().parse(strDate);
            } catch (ParseException e) {
                logger.warn("getString2Date出错。", e);
            }
        }
        return date;
    }

    /**
     * 将字符串日期yyyy-MM-dd HH:mm:ss:SSS转换为java.util.Date
     *
     * @param strDate
     * @return
     */
    public final static Date getString2DateSS(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormatSS().parse(strDate);
            } catch (ParseException e) {
                logger.error("getString2DateSS出错。", e);
            }
        }
        return date;
    }

    /**
     * 将字符串日期YYYYMMDDhhmmssSSS转换为java.util.Date
     * @param strDate
     * @return
     */
    public final static Date getString2DateSSS(String strDate){
        Date date=null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATSSS);
        if (!StringUtils.isEmpty(strDate)){
            try {
                date=sdf.parse(strDate);
            }catch (ParseException e){
                logger.error("getString2DateSSS出错。",e);
            }
        }
        return date;
    }

    /**
     * 将字符串日期yyyy/MM/dd HH:mm:ss转换为java.util.Date
     *
     * @param strDate
     * @return
     */
    public final static Date getString2DateOther(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormat2().parse(strDate);
            } catch (ParseException e) {
                logger.error("getString2DateOther出错。", e);
            }
        }
        return date;
    }

    /**
     * 将字符串日期yyyy-MM-dd转换为java.util.Date
     *
     * @param strDate
     * @return
     */
    public final static Date getString2DateDD(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormatDD().parse(strDate);
            } catch (ParseException e) {
                // date = defaultTime();
                logger.error("getString2DateDD出错。", e);
            }
        }
        return date;
    }

    /**
     * 将字符串日期yyyy-MM 转换为java.util.Date
     */
    public final static Date getString2DateMM(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormatMM().parse(strDate);
            } catch (ParseException e) {
                // date = defaultTime();
                logger.error("getString2DateMM出错。", e);
            }
        }
        return date;
    }

    /**
     * 取某天零点零分零秒零毫秒
     */
    public static Date getAnydayStart(int addDay) {
        Calendar calendar = Calendar.getInstance();
        // 如果没有这种设定的话回去系统的当期的时间
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        Date date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * Title: getString2DateHMS
     * Description:将字符串时间HH-mm-ss 转换为java.util.Date
     */
    public final static Date getString2DateHMS(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormatHMS().parse(strDate);
            } catch (ParseException e) {
                logger.error("getString2DateHMS出错。", e);
            }
        }
        return date;
    }

    /**
     * 获取默认时间
     */
    public static Date defaultTime() {
        Date d = new Date();
        try {
            d = getDateFormat().parse(DEFAULT_TIME);
        } catch (Exception e) {
            logger.error("defaultTime出错。", e);
        }
        return d;
    }

    public static boolean isBeforeDefaultTime(Date timeSpan) {
        boolean flag = false;
        try {
            flag = timeSpan.before(defaultTime());
        } catch (Exception e) {
            logger.error("isBeforeDefaultTime出错。", e);
        }
        return flag;
    }

    /**
     * Title: getDate
     * Description:获得时间 ，自定义day 和 hour
     */
    public static Date getDate(int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 获取某天之后的日期
     */
    public static Date getDateAfter(Date currDate, int days) {
        long l = currDate.getTime() + MILLIS_PER_DAY * days;
        return new Date(l);
    }

    /**
     * 获取某月之后的月份
     */
    public static Date getNextMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        Date nextDate = new Date(calendar.getTimeInMillis());
        return nextDate;
    }

    /**
     * Title: sysDate
     * Description:获取系统时间
     */
    public static Date sysDate() {
        return new Date();
    }

    /**
     * Title: sysTime
     * Description:获取系统时间 毫秒数
     */
    public static long sysTime() {
        return System.currentTimeMillis();
    }

    /**
     * Title: getDateYY
     * Description:返回 YYMMDD类型
     */
    public static String getDateYY(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMATY).format(date);
        return dateStr;
    }

    /**
     * Title: getDateYYMM
     * Description:返回 YYMM类型
     */
    public static String getDateYYMM(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMATM).format(date);
        return dateStr;
    }

    /**
     * Title: getDateYS
     * Description:返回HHmmss格式
     */
    public static String getDateHS(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMATHS).format(date);
        return dateStr;
    }

    /**
     * Title: getDateYMD
     * Description:返回yyyy-MM-dd格式
     */
    public static String getDateYMD(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMAT_DD).format(date);
        return dateStr;
    }

    /**
     * Title: getDateYM
     * Description:返回yyyy-MM格式
     */
    public static String getDateYM(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMAT_MM).format(date);
        return dateStr;
    }

    /**
     * Title: getMillis
     * Description:将date时间转换成毫秒数
     */
    public static Long getMillis(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            return (long) (((hour * 60 + minute) * 60 + second) * 1000);
        }
        return null;
    }

    /**
     * 几天前或者几天后的当前时间
     */
    public static Date getSystemTime(int addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        Date date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * Title: getDateSStr
     * Description:
     */
    public static String getDateSStr(Date date) {
        String dateStr = new SimpleDateFormat(DATE_FORMATSS).format(date);
        return dateStr;
    }

    /**
     * Title: getDateSStr
     * Description:取N小时后到 时间
     */
    public static Date getTimeAfterNHour(int n) {
        Date d = new Date();
        return getTimeAfterNHour(d, n);
    }

    /**
     * <p>Title: getTimeAfterNHour<／p>
     * <p>Description: 将date延后n小时<／p>
     */
    public static Date getTimeAfterNHour(Date date, int n) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR, now.get(Calendar.HOUR) + n);
        return now.getTime();
    }

    /**
     * 获取n分钟后的时间
     *
     * @param n
     * @return
     */
    public static Date getTimeAfterNMinute(int n) {
        Date d = new Date();
        return getTimeByMinute(d, n);
    }

    /**
     * 获取当前时间之前或之后几分钟 minute
     */
    public static Date getTimeByMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
        return calendar.getTime();
    }

    /**
     * <p>Title: getTimeAfterNMinutes<／p>
     * <p>Description: 将date延后n分钟<／p>
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getTimeAfterNMinutes(Date date, int n) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + n);
        return now.getTime();
    }

    /**
     * Worker失败后下次执行时间的算法类 第一次失败，再次执行任务的时间是1小时后 第二次失败，再次执行任务的时间是3小时后
     * 第三次失败，再次执行任务的时间是8小时后 第四次失败，再次执行任务的时间是12小时后 第五次失败，再次执行任务的时间是24小时后
     * 第六次失败，再次执行任务的时间是48小时后 第七次失败，任务不再执行
     *
     * @param exeCount
     * @return
     */
    public static Date getNextExeTime(int exeCount) {
        Date nextExeTime = null;
        switch (exeCount) {
            case 1:
                nextExeTime = DateUtil.getTimeAfterNHour(1);
                break;
            case 2:
                nextExeTime = DateUtil.getTimeAfterNHour(3);
                break;
            case 3:
                nextExeTime = DateUtil.getTimeAfterNHour(8);
                break;
            case 4:
                nextExeTime = DateUtil.getTimeAfterNHour(12);
                break;
            case 5:
                nextExeTime = DateUtil.getTimeAfterNHour(24);
                break;
            case 6:
                nextExeTime = DateUtil.getTimeAfterNHour(48);
                break;
            default:
                nextExeTime = DateUtil.getTimeAfterNHour(0);
                break;
        }
        return nextExeTime;
    }

    /**
     * @describe 将传过来的date进行格式化成0点0分0秒，年月日不变，并返回
     */
    public static Date formatDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 方法功能描述：将传过来的date进行格式化成23点59分59秒，年月日不变，并返回
     */
    public static Date formatDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 方法功能描述：将传过来的date进行格式化当月第一天的0点0分0秒0毫秒，年月不变，并返回
     */
    public static Date getFormatFirstDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 方法功能描述：将传过来的date进行格式化当月最后一天的23点59分59秒，年月不变，并返回
     */
    public static Date getFormatLastDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int days = calendar.get(Calendar.DATE);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, days);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 方法功能描述：将传过来的date进行格式化当月第二天的23点59分59秒999毫秒，年月不变，并返回
     */
    public static Date getFormatSecondDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        date = new Date(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 方法功能描述：将传过来的date进行格式化上月最后一天，时间不变，并返回
     */
    public static Date getFormatLastMonthLastDate() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 方法功能描述：将传过来的date进行格式化下月的某一天，时间不变，并返回
     */
    public static Date getFormatNextMonthSomeDate(int day) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 方法功能描述：将传过来的date进行格式化下月的某一天，时间不变，并返回
     * <b>参数说明</b>
     */
    public static Date getFormatThisMonthSomeDate(int day) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 取得上月第一天
     *
     * @return
     */
    public static String getFormatBefMonthFirstDayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date(calendar.getTimeInMillis());
        return getDateStr(date);
    }

    /**
     * 取得上月最后一天
     *
     * @return
     */
    public static String getFormatBefMonthLastDayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date date = new Date(calendar.getTimeInMillis());
        return getDateStr(date);
    }
}
