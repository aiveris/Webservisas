package model;

public class Stat {
    private String country_name;
    private String cases;
    private String deaths;
    private String total_recovered;
    private String new_deaths;
    private String new_cases;
    private String serious_critical;
    private String active_cases;
    private String total_cases_per_1m_population;

    public String getCountry_name() {
        return country_name;
    }

    public String getCases() {
        return cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public String getSerious_critical() {
        return serious_critical;
    }

    public String getActive_cases() {
        return active_cases;
    }

    public String getTotal_cases_per_1m_population() {
        return total_cases_per_1m_population;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "country_name='" + country_name + '\'' +
                ", cases='" + cases + '\'' +
                ", deaths='" + deaths + '\'' +
                ", total_recovered='" + total_recovered + '\'' +
                ", new_deaths='" + new_deaths + '\'' +
                ", new_cases='" + new_cases + '\'' +
                ", serious_critical='" + serious_critical + '\'' +
                ", active_cases='" + active_cases + '\'' +
                ", total_cases_per_1m_population='" + total_cases_per_1m_population + '\'' +
                '}';
    }
}
