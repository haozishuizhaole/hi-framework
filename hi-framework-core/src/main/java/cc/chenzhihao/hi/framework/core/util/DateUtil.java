package cc.chenzhihao.hi.framework.core.util;

import cc.chenzhihao.hi.framework.core.exception.Exceptions;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日期/时间工具
 *
 * @author jacksonchenzhihao
 * @date 2021-11-19 10:13
 */
public class DateUtil {

    public static final String PATTERN_LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_LOCAL_DATE_TIME_COMPACT = "yyyyMMddHHmmss";
    public static final String PATTERN_LOCAL_DATE_TIME_CN = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String PATTERN_LOCAL_DATE = "yyyy-MM-dd";
    public static final String PATTERN_LOCAL_DATE_COMPACT = "yyyyMMdd";
    public static final String PATTERN_LOCAL_DATE_CN = "yyyy年MM月dd日";
    public static final String PATTERN_LOCAL_TIME = "HH:mm:ss";
    public static final String PATTERN_LOCAL_TIME_COMPACT = "HHmmss";
    public static final String PATTERN_LOCAL_TIME_CN = "HH时mm分ss秒";

    /**
     * DateTimeFormatter 缓存
     */
    private static final Map<String, DateTimeFormatter> DATE_TIME_FORMATTER_MAP = new ConcurrentHashMap<>();

    /*************************************************日期时间计算**************************************************/

    /**
     * 某日期前/后n天是几号？
     *
     * @param date      日期
     * @param daysToAdd 加减天数。正数为加，负数为减
     * @return 目标日期
     */
    public static LocalDate plusDays(LocalDate date, long daysToAdd) {
        return date.plusDays(daysToAdd);
    }

    /**
     * 两个日期相差多少年
     */
    public static long diffYears(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.YEARS);
    }

    /**
     * 两个日期时间相差多少年
     */
    public static long diffYears(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.YEARS);
    }

    /**
     * 两个日期相差多少月
     */
    public static long diffMonths(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MONTHS);
    }

    /**
     * 两个日期时间相差多少月
     */
    public static long diffMonths(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MONTHS);
    }

    /**
     * 两个日期相差多少星期
     */
    public static long diffWeeks(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.WEEKS);
    }

    /**
     * 两个日期时间相差多少星期
     */
    public static long diffWeeks(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.WEEKS);
    }

    /**
     * 两个日期相差多少天
     */
    public static long diffDays(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.DAYS);
    }

    /**
     * 两个日期时间相差多少天
     */
    public static long diffDays(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.DAYS);
    }

    /**
     * 两个日期时间相差多少小时
     */
    public static long diffHours(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.HOURS);
    }

    /**
     * 两个日期相差多少小时
     */
    public static long diffHours(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.HOURS);
    }

    /**
     * 两个时钟时间相差多少小时
     */
    public static long diffHours(LocalTime sourceDate, LocalTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.HOURS);
    }

    /**
     * 两个日期时间相差多少分钟
     */
    public static long diffMinutes(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MINUTES);
    }

    /**
     * 两个日期相差多少分钟
     */
    public static long diffMinutes(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MINUTES);
    }

    /**
     * 两个时钟时间相差多少分钟
     */
    public static long diffMinutes(LocalTime sourceDate, LocalTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MINUTES);
    }

    /**
     * 两个日期时间相差多少秒
     */
    public static long diffSeconds(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.SECONDS);
    }

    /**
     * 两个日期相差多少秒
     */
    public static long diffSeconds(LocalDate sourceDate, LocalDate targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.SECONDS);
    }

    /**
     * 两个时钟时间相差多少秒
     */
    public static long diffSeconds(LocalTime sourceDate, LocalTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.SECONDS);
    }

    /**
     * 两个日期时间相差多少毫秒
     */
    public static long diffMillis(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return sourceDate.until(targetDate, ChronoUnit.MILLIS);
    }

    /**
     * 两个Date相差多少年
     */
    public static long diffYears(Date sourceDate, Date targetDate) {
        return diffYears(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /**
     * 两个Date相差多少月
     */
    public static long diffMonths(Date sourceDate, Date targetDate) {
        return diffMonths(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /**
     * 两个Date相差多少天
     */
    public static long diffDays(Date sourceDate, Date targetDate) {
        return diffDays(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /**
     * 两个Date相差多少小时
     */
    public static long diffHours(Date sourceDate, Date targetDate) {
        return diffHours(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /**
     * 两个Date相差多少分钟
     */
    public static long diffMinutes(Date sourceDate, Date targetDate) {
        return diffMinutes(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /**
     * 两个Date相差多少秒
     */
    public static long diffSeconds(Date sourceDate, Date targetDate) {
        return diffSeconds(convertDate2LocalDateTime(sourceDate), convertDate2LocalDateTime(targetDate));
    }

    /*************************************************起始 & 结束**************************************************/

    /**
     * 某天的开始时间
     */
    public static LocalDateTime beginDateTimeOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    /**
     * 某天的结束时间
     */
    public static LocalDateTime endDateTimeOfDay(LocalDate date) {
        return date.plusDays(1).atStartOfDay().plusNanos(-1);
    }

    /*************************************************昨天、今天、明天、某天**************************************************/

    /**
     * 当前日期时间
     */
    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 当前时钟时间
     */
    public static LocalTime currentTime() {
        return LocalTime.now();
    }

    /**
     * 今天几号？
     */
    public static LocalDate today() {
        return LocalDate.now();
    }

    /**
     * 今天是周几？
     */
    public static DayOfWeek todayDayOfWeek() {
        return today().getDayOfWeek();
    }

    /**
     * 昨天几号？
     */
    public static LocalDate yesterday() {
        return today().plusDays(-1);
    }

    /**
     * 昨天是周几？
     */
    public static DayOfWeek yesterdayDayOfWeek() {
        return yesterday().getDayOfWeek();
    }

    /**
     * 明天几号？
     */
    public static LocalDate tomorrow() {
        return today().plusDays(1);
    }

    /**
     * 明天是周几？
     */
    public static DayOfWeek tomorrowDayOfWeek() {
        return tomorrow().getDayOfWeek();
    }

    /**
     * m周n是几号？
     * m为周数，n为星期数
     * eg：
     * 上周三是几号？whatDateWasCertainDayOfWeek(-1, DayOfWeek.WEDNESDAY)
     * 下周日是几号？whatDateWasCertainDayOfWeek(1, DayOfWeek.SUNDAY)
     */
    public static LocalDate whatDateWasCertainDayOfWeek(int whichWeek, DayOfWeek week) {
        return LocalDate.now().plusWeeks(whichWeek).with(ChronoField.DAY_OF_WEEK, week.getValue());
    }

    /**
     * 本周n是几号？
     * n为星期数
     * eg：
     * 本周三是几号？whatDateWasCurrentWeek(DayOfWeek.WEDNESDAY)
     */
    public static LocalDate whatDateWasCurrentWeek(DayOfWeek week) {
        return whatDateWasCertainDayOfWeek(0, week);
    }

    /**
     * 下周n是几号？
     * n为星期数
     * eg：
     * 下周三是几号？whatDateWasNextWeek(DayOfWeek.WEDNESDAY)
     */
    public static LocalDate whatDateWasNextWeek(DayOfWeek week) {
        return whatDateWasCertainDayOfWeek(1, week);
    }

    /**
     * 上周n是几号？
     * n为星期数
     * eg：
     * 上周三是几号？whatDateWasLastWeek(DayOfWeek.WEDNESDAY)
     */
    public static LocalDate whatDateWasLastWeek(DayOfWeek week) {
        return whatDateWasCertainDayOfWeek(-1, week);
    }

    /**
     * 本月初是几号？
     */
    public static LocalDate firstDayOfThisMonth() {
        return today().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 本月末是几号？
     */
    public static LocalDate lastDayOfThisMonth() {
        return today().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 本年初是几号？
     */
    public static LocalDate firstDayOfThisYear() {
        return today().with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 本年末是几号？
     */
    public static LocalDate lastDayOfThisYear() {
        return today().with(TemporalAdjusters.lastDayOfYear());
    }

    /*************************************************JDK8 Date**************************************************/

    /**
     * 手动构造 LocalDateTime
     *
     * @param year       年
     * @param month      月[1,12]
     * @param dayOfMonth 日[1,31]
     * @param hour       时[0,23]
     * @param minute     分[0,59]
     * @param second     秒[0,59]
     * @return LocalDateTime
     */
    public static LocalDateTime ofLocalDateTime(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }

    /**
     * 手动构造 LocalDate
     *
     * @param year       年
     * @param month      月[1,12]
     * @param dayOfMonth 日[1,31]
     * @return LocalDate
     */
    public static LocalDate ofLocalDate(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * 手动构造 LocalTime
     *
     * @param hour   时[0,23]
     * @param minute 分[0,59]
     * @param second 秒[0,59]
     * @return LocalTime
     */
    public static LocalTime ofLocalTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

    /**
     * LocalDateTime -> String
     *
     * @param localDateTime localDateTime
     * @param pattern       日期时间格式
     * @return 日期时间格式化字符串
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(dateTimeFormatter(pattern));
    }

    /**
     * LocalDate -> String
     *
     * @param localDate localDate
     * @param pattern   日期时间格式
     * @return 日期时间格式化字符串
     */
    public static String formatLocalDate(LocalDate localDate, String pattern) {
        return localDate.format(dateTimeFormatter(pattern));
    }

    /**
     * LocalTime -> String
     *
     * @param localTime localTime
     * @param pattern   日期时间格式
     * @return 日期时间格式化字符串
     */
    public static String formatLocalTime(LocalTime localTime, String pattern) {
        return localTime.format(dateTimeFormatter(pattern));
    }

    /**
     * String -> LocalDateTime
     * <p>
     * 转换失败会抛出 {@code SystemException}
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalDateTime
     */
    public static LocalDateTime parseLocalDateTime(String dateStr, String pattern) {
        LocalDateTime result;
        try {
            result = LocalDateTime.parse(dateStr, dateTimeFormatter(pattern));
        } catch (Exception e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    /**
     * String -> LocalDateTime
     * <p>
     * 转换失败不会抛出异常，仅返回null，调用方需要手动判空
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalDateTime。 转换失败返回null
     */
    public static LocalDateTime parseLocalDateTimeWithoutError(String dateStr, String pattern) {
        LocalDateTime result;
        try {
            result = parseLocalDateTime(dateStr, pattern);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    /**
     * String -> LocalDate
     * <p>
     * 转换失败会抛出 {@code SystemException}
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalDate
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        LocalDate result;
        try {
            result = LocalDate.parse(dateStr, dateTimeFormatter(pattern));
        } catch (Exception e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    /**
     * String -> LocalDate
     * <p>
     * 转换失败不会抛出异常，仅返回null，调用方需要手动判空
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalDate。 转换失败返回null
     */
    public static LocalDate parseLocalDateWithoutError(String dateStr, String pattern) {
        LocalDate result;
        try {
            result = parseLocalDate(dateStr, pattern);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    /**
     * String -> LocalTime
     * <p>
     * 转换失败会抛出 {@code SystemException}
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalTime
     */
    public static LocalTime parseLocalTime(String dateStr, String pattern) {
        LocalTime result;
        try {
            result = LocalTime.parse(dateStr, dateTimeFormatter(pattern));
        } catch (Exception e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    /**
     * String -> LocalTime
     * <p>
     * 转换失败不会抛出异常，仅返回null，调用方需要手动判空
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return LocalTime。 转换失败返回null
     */
    public static LocalTime parseLocalTimeWithoutError(String dateStr, String pattern) {
        LocalTime result;
        try {
            result = parseLocalTime(dateStr, pattern);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    /*************************************************Date**************************************************/

    /**
     * Date -> String
     *
     * @param date    日期时间
     * @param pattern 日期时间格式
     * @return 日期时间格式化字符串
     */
    public static String formatDate(Date date, String pattern) {
        return simpleDateFormat(pattern).format(date);
    }

    /**
     * String -> Date
     * <p>
     * 转换失败会抛出 {@code SystemException}
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return 日期时间
     */
    public static Date parseDate(String dateStr, String pattern) {
        Date result;
        try {
            result = simpleDateFormat(pattern).parse(dateStr);
        } catch (Exception e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    /**
     * String -> Date
     * <p>
     * 转换失败不会抛出异常，仅返回null，调用方需要手动判空
     *
     * @param dateStr 日期时间格式化字符串
     * @param pattern 日期时间格式
     * @return 日期时间。转换失败返回null
     */
    public static Date parseDateWithoutError(String dateStr, String pattern) {
        Date result;
        try {
            result = parseDate(dateStr, pattern);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }


    /***************************************时间戳 与 Date & JDK8 Date****************************************/

    /**
     * 获取毫秒级时间戳，by LocalDateTime
     *
     * @param localDateTime LocalDateTime
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(LocalDateTime localDateTime) {
        return millTimestamp(localDateTime, systemDefaultZoneId());
    }

    /**
     * 获取毫秒级时间戳，by LocalDateTime
     *
     * @param localDateTime LocalDateTime
     * @param zoneId        时区
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(LocalDateTime localDateTime, ZoneId zoneId) {
        return millTimestamp(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * 获取毫秒级时间戳，by LocalDate
     *
     * @param localDate LocalDate
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(LocalDate localDate) {
        return millTimestamp(localDate, systemDefaultZoneId());
    }

    /**
     * 获取毫秒级时间戳，by LocalDate
     *
     * @param localDate LocalDate
     * @param zoneId    时区
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(LocalDate localDate, ZoneId zoneId) {
        return millTimestamp(localDate.atStartOfDay(), zoneId);
    }

    /**
     * 获取毫秒级时间戳，by Date
     *
     * @param date Date
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(Date date) {
        return millTimestamp(date, systemDefaultZoneId());
    }

    /**
     * 获取毫秒级时间戳，by Date
     *
     * @param date   Date
     * @param zoneId 时区
     * @return 毫秒级时间戳
     */
    public static long millTimestamp(Date date, ZoneId zoneId) {
        return millTimestamp(toInstant(date).atZone(zoneId).toInstant());
    }

    /**
     * 毫秒级时间戳 转 LocalDateTime
     *
     * @param millTimestamp 毫秒级时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime millTimestamp2LocalDateTime(long millTimestamp) {
        return millTimestamp2LocalDateTime(millTimestamp, systemDefaultZoneId());
    }


    /**
     * 毫秒级时间戳 转 LocalDateTime
     *
     * @param millTimestamp 毫秒级时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime millTimestamp2LocalDateTime(long millTimestamp, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = systemDefaultZoneId();
        }
        return toInstant(millTimestamp).atZone(zoneId).toLocalDateTime();
    }

    /**
     * 毫秒级时间戳 转 LocalDate
     *
     * @param millTimestamp 毫秒级时间戳
     * @return LocalDate
     */
    public static LocalDate millTimestamp2LocalDate(long millTimestamp) {
        return millTimestamp2LocalDate(millTimestamp, systemDefaultZoneId());
    }

    /**
     * 毫秒级时间戳 转 LocalDate
     *
     * @param millTimestamp 毫秒级时间戳
     * @return LocalDate
     */
    public static LocalDate millTimestamp2LocalDate(long millTimestamp, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = systemDefaultZoneId();
        }
        return toInstant(millTimestamp).atZone(zoneId).toLocalDate();
    }

    /**
     * 毫秒级时间戳 转 Date
     *
     * @param millTimestamp 毫秒级时间戳
     * @return Date
     */
    public static Date millTimestamp2Date(long millTimestamp) {
        return new Date(millTimestamp);
    }

    /***************************************Date 与 JDK8 Date 转换****************************************/

    /**
     * Date -> LocalDateTime
     */
    public static LocalDateTime convertDate2LocalDateTime(Date date) {
        return convertDate2LocalDateTime(date, systemDefaultZoneId());
    }

    /**
     * Date -> LocalDateTime
     */
    public static LocalDateTime convertDate2LocalDateTime(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * Date -> LocalDate
     */
    public static LocalDate convertDate2LocalDate(Date date) {
        return convertDate2LocalDateTime(date).toLocalDate();
    }

    /**
     * Date -> LocalDate
     */
    public static LocalDate convertDate2LocalDate(Date date, ZoneId zoneId) {
        return convertDate2LocalDateTime(date, zoneId).toLocalDate();
    }

    /**
     * Date -> LocalTime
     */
    public static LocalTime convertDate2LocalTime(Date date) {
        return convertDate2LocalDateTime(date).toLocalTime();
    }

    /**
     * Date -> LocalTime
     */
    public static LocalTime convertDate2LocalTime(Date date, ZoneId zoneId) {
        return convertDate2LocalDateTime(date, zoneId).toLocalTime();
    }

    /**
     * LocalDateTime -> Date
     */
    public static Date convertLocalDateTime2Date(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * LocalDateTime -> Date
     */
    public static Date convertLocalDateTime2Date(LocalDateTime localDateTime) {
        return convertLocalDateTime2Date(localDateTime, systemDefaultZoneId());
    }

    /**
     * LocalDate -> Date
     */
    public static Date convertLocalDate2Date(LocalDate localDate, ZoneId zoneId) {
        return convertLocalDateTime2Date(beginDateTimeOfDay(localDate), zoneId);
    }

    /**
     * LocalDate -> Date
     */
    public static Date convertLocalDate2Date(LocalDate localDate) {
        return convertLocalDateTime2Date(beginDateTimeOfDay(localDate), systemDefaultZoneId());
    }

    /*******************************私有方法*****************************/

    private static long millTimestamp(Instant instant) {
        return instant.toEpochMilli();
    }

    private static Instant toInstant(long millTimestamp) {
        return Instant.ofEpochMilli(millTimestamp);
    }

    private static Instant toInstant(Date date) {
        return date.toInstant();
    }

    private static ZoneId getZoneId(ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = systemDefaultZoneId();
        }
        return zoneId;
    }

    private static ZoneId systemDefaultZoneId() {
        return ZoneId.systemDefault();
    }

    private static SimpleDateFormat simpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    private static DateTimeFormatter dateTimeFormatter(String pattern) {
        DateTimeFormatter formatter;
        if ((formatter = DATE_TIME_FORMATTER_MAP.get(pattern)) == null) {
            formatter = DateTimeFormatter.ofPattern(pattern);
            DATE_TIME_FORMATTER_MAP.put(pattern, formatter);
        }
        return formatter;
    }

}
