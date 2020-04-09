import model.Countries;
import model.Stat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.CovidServiceAPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {
        String BASE_URL = "https://coronavirus-monitor.p.rapidapi.com/";
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        CovidServiceAPI covidServiceAPI = retrofit.create(CovidServiceAPI.class);
        Call<Countries> call = covidServiceAPI.getInfectedCountries();

        //sinchroninis BLOKUOS PAGRINDINĮ PROCESĄ
//        Countries countries = call.execute().body();
//        System.out.println(countries);

        call.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Countries countries = response.body();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter country");
                    String my_country = scanner.next();
                    for(Stat s: countries.getCountries_stat()){
                        if(s.getCountry_name().toUpperCase().equals(my_country.toUpperCase())){
                            System.out.println(ANSI_BLUE+s.getCountry_name()+ANSI_RESET);
                            System.out.println("Infected: "+ANSI_YELLOW+s.getActive_cases()+ANSI_RESET);
                            System.out.println("Deaths: "+ANSI_RED+s.getDeaths()+ANSI_RESET);
                            System.out.println("Recovered: "+ANSI_GREEN+s.getTotal_recovered()+ANSI_RESET);
                            System.out.println("--------------");
                        }
                    }
                    int counter = 0;
                    System.out.println("How many top countries");
                    int howMany = scanner.nextInt();
                    for(Stat s: countries.getCountries_stat()){
                        if(counter < howMany){
                            System.out.println(ANSI_BLUE+s.getCountry_name()+ANSI_RESET);
                            System.out.println("Infected: "+ANSI_YELLOW+s.getActive_cases()+ANSI_RESET);
                            System.out.println("Deaths: "+ANSI_RED+s.getDeaths()+ANSI_RESET);
                            System.out.println("Recovered: "+ANSI_GREEN+s.getTotal_recovered()+ANSI_RESET);
                            System.out.println("--------------");
                        }
                        counter++;
                    }
                }
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
