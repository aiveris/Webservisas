package model;


import java.util.List;

public class Countries {

private List<Stat> countries_stat;
private String statistic_taken_at;

    public List<Stat> getCountries_stat() {
        return countries_stat;
    }

    public String getStatistic_taken_at() {
        return statistic_taken_at;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countries_stat=" + countries_stat +
                ", statistic_taken_at='" + statistic_taken_at + '\'' +
                '}';
    }
}
