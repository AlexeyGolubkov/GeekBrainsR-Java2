public class WeatherResponse {
    Location LocationObject;
    Current CurrentObject;
    Forecast ForecastObject;


    // Getter Methods

    public Location getLocation() {
        return LocationObject;
    }

    public Current getCurrent() {
        return CurrentObject;
    }

    public Forecast getForecast() {
        return ForecastObject;
    }

    // Setter Methods

    public void setLocation(Location locationObject) {
        this.LocationObject = locationObject;
    }

    public void setCurrent(Current currentObject) {
        this.CurrentObject = currentObject;
    }

    public void setForecast(Forecast forecastObject) {
        this.ForecastObject = forecastObject;
    }
}

