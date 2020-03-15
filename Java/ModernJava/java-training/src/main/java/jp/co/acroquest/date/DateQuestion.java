package jp.co.acroquest.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Answer following questions.<BR>
 *
 * @see <a href="https://www.baeldung.com/java-8-date-time-intro">Baeldung.com - Introduction to the Java 8 Date/Time API</a>
 * @see <a href="https://www.baeldung.com/java-zoneddatetime-offsetdatetime">Baeldung.com - Differences Between ZonedDateTime and OffsetDateTime</a>
 */
public class DateQuestion
{

    /**
     * Question:
     * <pre>
     *     Create LocalDateTime that indicates 2020-04-01 10:00:00.
     * </pre>
     *
     * @return LocalDateTime
     */
    public LocalDateTime createLocalDateTime()
    {
        return LocalDateTime.of(2020, 04, 01, 10, 00, 00);
    }

    /**
     * Question:
     * <pre>
     *     Create OffsetDateTime that indicates 2020-04-10 12:30:00 (UTC).
     * </pre>
     *
     * @return OffsetDateTime
     */
    public OffsetDateTime createOffsetDateTime()
    {
        return OffsetDateTime.of(LocalDateTime.of(2020, 4, 10, 12, 30, 00),
                ZoneOffset.UTC);
    }

    /**
     * Question:
     * <pre>
     *     Create ZonedDateTime that indicates 2020-08-03 12:23:34 by using specified zone ID.
     * </pre>
     *
     * @param zoneId Zone ID
     * @return ZonedDateTime
     */
    public ZonedDateTime createZonedDateTime(String zoneId)
    {
        LocalDateTime newLTD = LocalDateTime.of(2020, Month.AUGUST, 3, 12, 23,
                34);
        return newLTD.atZone(ZoneId.of(zoneId));
    }

    /**
     * Question:
     * <pre>
     *     Create LocalDateTime by given Instant and zone ID.
     * </pre>
     *
     * @param instant Instant
     * @param zoneId  Zone ID
     * @return LocalDateTime
     */
    public LocalDateTime createLocalDateTimeFromInstant(Instant instant,
            String zoneId)
    {
        return LocalDateTime.ofInstant(instant, ZoneId.of(zoneId));
    }

    /**
     * Question:
     * <pre>
     *     Return the later of given two date.
     * </pre>
     *
     * @param date1 Date 1
     * @param date2 Date 2
     * @return The later of two date.
     */
    public boolean compare(LocalDate date1, LocalDate date2)
    {
        return (date1.compareTo(date2) > 0);
    }

    /**
     * Question:
     * <pre>
     *     Return LocalDate with the specified number of days added.
     * </pre>
     *
     * @param date LocalDate
     * @return LocalDate
     */
    public LocalDate plus3Days(LocalDate date)
    {
        return date.plusDays(3);
    }

    /**
     * Question:
     * <pre>
     *     Parse a temporal string to LocalDateTime.
     *     e.g. 2019/10/30 15:29
     * </pre>
     *
     * @param dateTimeString Temporal string
     * @return LocalDateTime
     */
    public LocalDateTime parseDateTimeString(String dateTimeString)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "yyyy/MM/dd HH:mm");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * Question:
     * <pre>
     *     Parse a temporal string to OffsetDateTime.
     *     e.g. 2019-10-05T10:40:20+09:00
     * </pre>
     *
     * @param dateTimeString Temporal string
     * @return OffsetDateTime
     */
    public OffsetDateTime parseOffsetDateTimeString(String dateTimeString)
    {
        return OffsetDateTime.parse(dateTimeString);
    }

    /**
     * Question:
     * <pre>
     *     Format LocalDateTime with specified format.
     *     e.g. 2019/10/05 10:40:20
     * </pre>
     *
     * @param dateTime
     * @return
     */
    public String formatLocalDateTime(LocalDateTime dateTime)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(
                "yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(dateTime).toString();
    }

    /**
     * Question:
     * <pre>
     *     Convert java.util.Date to OffsetDateTime by using given offset ID.
     * </pre>
     *
     * @param dateTime LocalDateTime
     * @param offsetId Offset ID
     * @return OffsetDateTime
     */
    public OffsetDateTime convertJavaUtilDateToOffsetDateTime(Date dateTime,
            String offsetId)
    {
        LocalDateTime newLocalDateTime = LocalDateTime.ofInstant(
                dateTime.toInstant(), ZoneId.systemDefault());
        return OffsetDateTime.of(newLocalDateTime,
                ZoneOffset.of(offsetId));
    }

    /**
     * Question:
     * <pre>
     *      Convert JST date time to MMT date time with same instant.
     *      JST ... standard time zone in Japan (UTC +09:00)
     *      MMT ... standard time zone in Myanmar (UTC +06:30)
     *
     *      Caution: Must not use plusHours(int hours). Use OffsetDateTime or ZonedDateTime.
     * </pre>
     *
     * @param jstDateTime JST date time
     * @return MMT date time
     */
    public LocalDateTime convertJstDateTimeToMmtDateTime(
            LocalDateTime jstDateTime)
    {
        ZoneId oldZone = ZoneId.of("Japan");
        ZoneId newZone = ZoneId.of("Asia/Yangon");
        return jstDateTime.atZone(oldZone).withZoneSameInstant(
                newZone).toLocalDateTime();
    }
}
