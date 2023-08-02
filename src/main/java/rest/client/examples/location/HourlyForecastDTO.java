package rest.client.examples.location;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyForecastDTO {

    private String location;

    @JsonProperty("hourly_forecast")
    private List<HourlyWeather> hourlyForecastDTOs = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<HourlyWeather> getHourlyForecastDTOs() {
        return hourlyForecastDTOs;
    }

    public void setHourlyForecastDTOs(List<HourlyWeather> hourlyForecastDTOs) {
        this.hourlyForecastDTOs = hourlyForecastDTOs;
    }
}
