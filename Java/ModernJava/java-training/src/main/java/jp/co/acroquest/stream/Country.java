package jp.co.acroquest.stream;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Country {

    private String name;
    private Continent continent;
    private long population;
    private long area;
    private BigDecimal gdp;

    public Country(String name, Continent continent, long population, long area, BigDecimal gdp) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public Optional<BigDecimal> getGdp() {
        return Optional.ofNullable(gdp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Country country = (Country)o;
        return population == country.population && area == country.area && Objects.equals(name, country.name)
                && continent == country.continent && Objects.equals(gdp, country.gdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, continent, population, area, gdp);
    }
}
