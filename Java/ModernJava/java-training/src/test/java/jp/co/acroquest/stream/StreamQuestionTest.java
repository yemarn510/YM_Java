package jp.co.acroquest.stream;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StreamQuestionTest
{

    private StreamQuestion target     = new StreamQuestion();

    private Country        france     = france();

    private Country        japan      = japan();

    private Country        myanmar    = myanmar();

    private Country        usa        = usa();

    private Country        antarctica = antarctica();

    @Test
    void createStream()
    {
        Stream<String> stream = target.createStream(List.of("a", "b"));
        assertNotNull(stream);
        assertThat(stream.collect(Collectors.toList())).containsExactly("a",
                "b");
    }

    @Test
    void createStreamFromArray()
    {
        Stream<String> stream = target.createStreamFromArray(new String[]
        { "a", "b", "c" });
        assertNotNull(stream);
        assertThat(stream.collect(Collectors.toList())).containsExactly("a",
                "b", "c");
    }

    @Test
    void streamToSet()
    {
        LocalDate date1 = LocalDate.of(2019, 8, 1);
        LocalDate date2 = LocalDate.of(2019, 8, 2);
        LocalDate date3 = LocalDate.of(2019, 8, 3);
        Set<LocalDate> list = target.streamToSet(
                Stream.of(date1, date2, date3, date1));
        assertNotNull(list);
        assertEquals(3, list.size());
        assertThat(list).containsExactlyInAnyOrder(date1, date2, date3);
    }

    @Test
    void joinStreams()
    {
        LocalDate date1 = LocalDate.of(2019, 8, 1);
        LocalDate date2 = LocalDate.of(2019, 8, 2);
        LocalDate date3 = LocalDate.of(2019, 8, 3);
        LocalDate date4 = LocalDate.of(2019, 8, 4);
        Stream<LocalDate> joinedStream = target.joinStreams(
                Stream.of(date1, date2), Stream.of(date3, date4));
        assertNotNull(joinedStream);
        assertThat(joinedStream.collect(Collectors.toList())).containsExactly(
                date1, date2, date3, date4);
    }

    @Test
    void groupByContinent()
    {
        Map<Continent, List<Country>> map = target.groupByContinent(
                List.of(japan, myanmar, usa, france));
        assertNotNull(map);
        assertEquals(3, map.size());
        assertThat(map.get(Continent.ASIA)).containsExactly(japan, myanmar);
        assertThat(map.get(Continent.AMERICA)).containsExactly(usa);
        assertThat(map.get(Continent.EUROPE)).containsExactly(france);
    }

    @Test
    void convertToCountryNameList()
    {
        List<String> countryNameList = target.convertToCountryNameList(
                List.of(usa, myanmar, japan));
        assertNotNull(countryNameList);
        assertEquals(3, countryNameList.size());
        assertThat(countryNameList).containsExactly(usa.getName(),
                myanmar.getName(), japan.getName());
    }

    @Test
    void filterByArea()
    {
        List<Country> countryList = target.filterByArea(
                List.of(japan, myanmar, usa, france));
        assertNotNull(countryList);
        assertEquals(3, countryList.size());
        assertThat(countryList).containsExactly(myanmar, usa, france);
    }

    @Test
    void sumPopulation()
    {
        long population = target.sumPopulation(List.of(usa, myanmar));
        assertEquals(380_570_000, population);
    }

    @Test
    void sumGdp()
    {
        BigDecimal gdp = target.sumGdp(
                List.of(france, usa, myanmar, japan, antarctica));
        assertNotNull(gdp);
        assertEquals(BigDecimal.valueOf(2_652_320_000_000L), gdp);
    }

    @Test
    void getMaxGdpForEachContinent()
    {
        Map<Continent, BigDecimal> maxGdpForEachContinent = target.getMaxGdpForEachContinent(
                List.of(japan, myanmar, usa, france, antarctica));
        assertNotNull(maxGdpForEachContinent);
        assertEquals(4, maxGdpForEachContinent.size());
        assertEquals(BigDecimal.valueOf(4_872_000_000_000L),
                maxGdpForEachContinent.get(Continent.ASIA));
        assertEquals(BigDecimal.valueOf(19_390_000_000_000L),
                maxGdpForEachContinent.get(Continent.AMERICA));
        assertEquals(BigDecimal.valueOf(2_583_000_000_000L),
                maxGdpForEachContinent.get(Continent.EUROPE));
        assertEquals(BigDecimal.ZERO,
                maxGdpForEachContinent.get(Continent.ANTARCTICA));
    }

    private Country japan()
    {
        return new Country("Japan", Continent.ASIA, 127_000_000, 378_000,
                BigDecimal.valueOf(4_872_000_000_000L));
    }

    private Country myanmar()
    {
        return new Country("Myanmar", Continent.ASIA, 53_370_000, 676_000,
                BigDecimal.valueOf(69_320_000_000L));
    }

    private Country usa()
    {
        return new Country("The United States of America", Continent.AMERICA,
                327_200_000, 9_834_000,
                BigDecimal.valueOf(19_390_000_000_000L));
    }

    private Country france()
    {
        return new Country("France", Continent.EUROPE, 66_990_000, 634_800,
                BigDecimal.valueOf(2_583_000_000_000L));
    }

    private Country antarctica()
    {
        return new Country("Antarctica", Continent.ANTARCTICA, 1000, 14_000_000,
                null);
    }
}
