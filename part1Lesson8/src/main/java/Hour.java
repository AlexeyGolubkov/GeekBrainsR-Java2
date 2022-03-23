
public class Hour {
    private String time;
    private float temp_c;
    private float is_day;
    Condition ConditionObject;
    private float wind_kph;
    private String wind_dir;
    private float will_it_rain;
    private float will_it_snow;
    private float vis_km;


    // Getter Methods

    public String getTime() {
        return time;
    }

    public float getTemp_c() {
        return temp_c;
    }

    public float getIs_day() {
        return is_day;
    }

    public Condition getCondition() {
        return ConditionObject;
    }

    public float getWind_kph() {
        return wind_kph;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public float getWill_it_rain() {
        return will_it_rain;
    }

    public float getWill_it_snow() {
        return will_it_snow;
    }

    public float getVis_km() {
        return vis_km;
    }

    // Setter Methods

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
    }

    public void setIs_day(float is_day) {
        this.is_day = is_day;
    }

    public void setCondition(Condition conditionObject) {
        this.ConditionObject = conditionObject;
    }

    public void setWind_kph(float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public void setWill_it_rain(float will_it_rain) {
        this.will_it_rain = will_it_rain;
    }

    public void setWill_it_snow(float will_it_snow) {
        this.will_it_snow = will_it_snow;
    }

    public void setVis_km(float vis_km) {
        this.vis_km = vis_km;
    }

}