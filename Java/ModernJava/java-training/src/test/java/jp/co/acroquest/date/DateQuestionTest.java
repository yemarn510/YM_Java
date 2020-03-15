package jp.co.acroquest.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateQuestionTest
{

    private DateQuestion target = new DateQuestion();

    @Test
    void createLocalDateTime()
    {
        LocalDateTime actual = target.createLocalDateTime();
        LocalDateTime expected = LocalDateTime.of(2020, 4, 1, 10, 0, 0);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test ///
    void createOffsetDateTime()
    {
        OffsetDateTime actual = target.createOffsetDateTime();
        OffsetDateTime expected = OffsetDateTime.of(
                LocalDateTime.of(2020, 4, 10, 12, 30, 00), ZoneOffset.UTC);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void createZonedDateTime()
    {
        LocalDateTime expected = LocalDateTime.of(2020, 8, 3, 12, 23, 34);
        ZonedDateTime tokyoDate = target.createZonedDateTime("Asia/Tokyo");
        assertNotNull(tokyoDate);
        assertEquals(expected, tokyoDate.toLocalDateTime());
        assertEquals("Asia/Tokyo", tokyoDate.getZone().getId());

        ZonedDateTime chicagoDate = target.createZonedDateTime(
                "America/Chicago");
        assertNotNull(chicagoDate);
        assertEquals(expected, chicagoDate.toLocalDateTime());
        assertEquals("America/Chicago", chicagoDate.getZone().getId());
    }

    @Test
    void createLocalDateTimeFromInstant()
    {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(
                LocalDateTime.of(2019, 10, 31, 18, 35, 13), ZoneOffset.UTC);
        String zoneId = "Asia/Tokyo";
        LocalDateTime actual = target.createLocalDateTimeFromInstant(
                offsetDateTime.toInstant(), zoneId);
        assertNotNull(actual);
        LocalDateTime expected = LocalDateTime.of(2019, 11, 1, 3, 35, 13);
        assertEquals(expected, actual);
    }

    @Test
    void compare()
    {
        LocalDate equal = LocalDate.of(2020, 1, 1);
        assertFalse(target.compare(equal, equal));
        LocalDate later = LocalDate.of(2020, 1, 1);
        LocalDate earlier = LocalDate.of(2019, 12, 31);
        assertFalse(target.compare(earlier, later));
        assertTrue(target.compare(later, earlier));
    }

    @Test
    void plus3Days()
    {
        LocalDate before = LocalDate.of(2019, 12, 30);
        LocalDate after = target.plus3Days(before);
        assertNotNull(after);
        LocalDate expected = LocalDate.of(2020, 1, 2);
        assertEquals(expected, after);
    }

    @Test
    void parseDateTimeString()
    {
        String validString = "2018/01/23 21:54";
        LocalDateTime actual = target.parseDateTimeString(validString);
        LocalDateTime expected = LocalDateTime.of(2018, 1, 23, 21, 54);
        assertNotNull(actual);
        assertEquals(expected, actual);

        String invalidString = "2019-01-01 10:00";
        assertThrows(DateTimeParseException.class,
                () -> target.parseDateTimeString(invalidString));
    }

    @Test
    void parseOffsetDateTimeString()
    {
        String validString = "2019-10-20T10:40:20+09:00";
        OffsetDateTime actual = target.parseOffsetDateTimeString(validString);
        OffsetDateTime expected = OffsetDateTime.of(
                LocalDateTime.of(2019, 10, 20, 10, 40, 20),
                ZoneOffset.of("+09:00"));
        assertNotNull(actual);
        assertEquals(expected, actual);

        String invalidString = "2019/10/20 10:40:20+09:00";
        assertThrows(DateTimeParseException.class,
                () -> target.parseDateTimeString(invalidString));
    }

    @Test
    void formatLocalDateTime()
    {
        LocalDateTime dateTime = LocalDateTime.of(2019, 12, 23, 16, 32, 55);
        String actual = target.formatLocalDateTime(dateTime);
        assertNotNull(actual);
        assertEquals("2019/12/23 16:32:55", actual);
    }

    @Test
    void convertJavaUtilDateToOffsetDateTime()
    {
        String offsetId = "+06:30";
        OffsetDateTime expected = OffsetDateTime.of(
                LocalDateTime.of(2020, 8, 1, 8, 45, 0),
                ZoneOffset.of(offsetId));
        Date javaUtilDate = Date.from(expected.toInstant());
        OffsetDateTime actual = target.convertJavaUtilDateToOffsetDateTime(
                javaUtilDate, offsetId);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void convertJstDateTimeToMmtDateTime()
    {
        LocalDateTime jstDateTime = LocalDateTime.of(2019, 10, 31, 18, 23, 11);
        LocalDateTime mmtDateTime = LocalDateTime.of(2019, 10, 31, 15, 53, 11);
        LocalDateTime actual = target.convertJstDateTimeToMmtDateTime(
                jstDateTime);
        assertNotNull(actual);
        assertEquals(mmtDateTime, actual);
    }
}
