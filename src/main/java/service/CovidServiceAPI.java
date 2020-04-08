package service;

import model.Countries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CovidServiceAPI {
    // HTTP REQUEST

    @Headers({
        "x-rapidapi-host:coronavirus-monitor.p.rapidapi.com",
        "x-rapidapi-key:2a0534ef28msh6224b4343d62cccp1b0acdjsnbf472465d60f"
})
    @GET("coronavirus/cases_by_country.php")
    Call<Countries> getInfectedCountries();

}
