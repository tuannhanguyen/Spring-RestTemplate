package rest.client.examples.location;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealtimeWeather {

    private int temperature;

    private int humidity;

    private int precipation;

    @JsonProperty("wind_speed")
    private int windSpeed;

    private String status;

    @JsonProperty("last_updated")
    private Date lastUpdated;

    private String location;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPrecipation() {
        return precipation;
    }

    public void setPrecipation(int precipation) {
        this.precipation = precipation;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "[Location=" + location +", " + "RealtimeWeather = [temperature=" + temperature + ", humidity=" + humidity + ", precipation=" + precipation
                + ", windSpeed=" + windSpeed + ", status=" + status + ", lastUpdated=" + lastUpdated +"]]";
    }
}
