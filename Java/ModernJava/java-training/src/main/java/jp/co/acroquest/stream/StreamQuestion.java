package jp.co.acroquest.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Answer following questions.<BR>
 * Caution: Do NOT use for statements.
 *
 * @see <a href="https://www.baeldung.com/java-streams">Baeldung.com - Java Streams</a>
 */
public class StreamQuestion
{

    /**
     * Question 1:
     * <pre>
     *      Create a stream by given list.
     * </pre>
     *
     * @param list
     * @return Stream<String>
     */
    public Stream<String> createStream(List<String> list)
    {
        return list.stream();
    }

    /**
     * Question 2:
     * <pre>
     *     Create a stream from given array.
     * </pre>
     *
     * @param strings
     * @return  Stream<String>
     */
    public Stream<String> createStreamFromArray(String[] strings)
    {
        return Arrays.stream(strings);
    }

    /**
     * Question 3:
     * <pre>
     *     Convert given stream to java.util.Set.
     * </pre>
     *
     * @param dateStream
     * @return Set<LocalDate>
     */
    public Set<LocalDate> streamToSet(Stream<LocalDate> dateStream)
    {
        return dateStream.collect(Collectors.toSet());
    }

    /**
     * Question 4:
     * <pre>
     *     Join given 2 streams.
     * </pre>
     *
     * @param stream1
     * @param stream2
     * @return Stream<LocalDate>
     */
    public Stream<LocalDate> joinStreams(Stream<LocalDate> stream1,
            Stream<LocalDate> stream2)
    {
        return Stream.concat(stream1, stream2);
    }

    /**
     * Question 5:
     * <pre>
     *     Group countries by its continent.
     * </pre>
     *
     * @param countryList
     * @return conitnents Map<Continent, List<Country>>
     */
    public Map<Continent, List<Country>> groupByContinent(
            List<Country> countryList)
    {
        Map<Continent, List<Country>> conitnents = new HashMap<Continent, List<Country>>();
        for (Country country : countryList)
        {
            int indexx = 0;
            if (conitnents.get(country.getContinent()) == null)
            {
                List<Country> newCountries = new ArrayList<Country>();
                newCountries.add(indexx, country);
                conitnents.put(country.getContinent(), newCountries);
            }
            else
            {
                indexx++;
                List<Country> oo = conitnents.get(country.getContinent());
                oo.add(indexx, country);
                conitnents.put(country.getContinent(), oo);
            }
        }
        return conitnents;
    }

    /**
     * Question 6:
     * <pre>
     *      Convert given country list to country name list.
     *      Caution: Use stream() and map().
     * </pre>
     *
     * @param countryList
     * @return List<String>
     */
    public List<String> convertToCountryNameList(List<Country> countryList)
    {
        return countryList.stream().map(
                country -> country.getName()).collect(Collectors.toList());
    }

    /**
     * Question 7:
     * <pre>
     *     Subset given list following the condition that the area of the country is over 500,000.
     * </pre>
     *
     * @param countryList
     * @return List<Country>
     */
    public List<Country> filterByArea(List<Country> countryList)
    {
        List<Country> countryX = new ArrayList<Country>();
        int index = 0;
        //        return countryList.stream().filter(x -> x.getArea() > 50000).collect(
        //                Collectors.toList());
        for (Country country : countryList)
        {
            if (country.getArea() > 500000)
            {
                countryX.add(index, country);
                index++;
            }
        }
        return countryX;
    }

    /**
     * Question 8:
     * <pre>
     *     Sum populations of all counties in given list.
     * </pre>
     *
     * @param countryList
     * @return
     */
    public long sumPopulation(List<Country> countryList)
    {
        long population = 0;
        //        countryList.stream().map(x -> x.getPopulation()).forEach(
        //                System.out::println);

        for (Country country : countryList)
        {
            population = population + country.getPopulation();
        }
        return population;
    }

    /**
     * Question 9:
     * <pre>
     *     Sum GDP of the country of which population is less than 100,000,000.
     * </pre>
     *
     * @param countryList
     * @return
     */
    public BigDecimal sumGdp(List<Country> countryList)
    {
        BigDecimal sum = new BigDecimal(0.00);
        for (Country country : countryList)
        {
            BigDecimal incomeGDP = new BigDecimal(0.00);
            try
            {
                incomeGDP = country.getGdp().get();
            }
            catch (Exception ex)
            {
                //ex.printStackTrace();
            }
            if (country.getPopulation() < 100000000)
            {
                sum = sum.add(incomeGDP);
            }
        }
        return sum;
    }

    /**
     * Question 10:
     * <pre>
     *     Get max GDP among the countries for each continent.
     *     If any GDP is not present, set ZERO.
     * </pre>
     *
     * @param countryList
     * @return map Map<Continent, BigDecimal>
     */
    public Map<Continent, BigDecimal> getMaxGdpForEachContinent(
            List<Country> countryList)
    {
        Map<Continent, BigDecimal> map = new HashMap<Continent, BigDecimal>();
        for (Country country : countryList)
        {
            if (map.get(country.getContinent()) == null)
            {
                BigDecimal incomeGDP = new BigDecimal(0.00);
                try
                {
                    incomeGDP = country.getGdp().get();
                }
                catch (Exception ex)
                {
                    incomeGDP = BigDecimal.ZERO;
                }
                map.put(country.getContinent(), incomeGDP);
            }
            else
            {
                BigDecimal newGDP = new BigDecimal(0.00);
                BigDecimal incomeGDP = map.get(country.getContinent());
                try
                {
                    newGDP = country.getGdp().get();
                }
                catch (Exception ex)
                {
                    //
                }
                if (newGDP.max(incomeGDP) != null)
                {
                    map.put(country.getContinent(), incomeGDP);
                }
            }
        }
        return map;
    }
}
