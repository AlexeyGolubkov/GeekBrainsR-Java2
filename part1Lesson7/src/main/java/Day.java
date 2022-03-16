public class Day {
    private float maxtemp_c;
    private float mintemp_c;
    private float avgtemp_c;
    private float maxwind_kph;
    private float totalprecip_mm;
    private float avgvis_km;
    private float daily_will_it_rain;
    private float daily_will_it_snow;
    Condition ConditionObject;


    // Getter Methods

    public float getMaxtemp_c() {
        return maxtemp_c;
    }

    public float getMintemp_c() {
        return mintemp_c;
    }

    public float getAvgtemp_c() {
        return avgtemp_c;
    }

    public float getMaxwind_kph() {
        return maxwind_kph;
    }

    public float getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public float getAvgvis_km() {
        return avgvis_km;
    }

    public float getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public float getDaily_will_it_snow() {
        return daily_will_it_snow;
    }

    public Condition getCondition() {
        return ConditionObject;
    }

    // Setter Methods

    public void setMaxtemp_c(float maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public void setMintemp_c(float mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public void setAvgtemp_c(float avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public void setMaxwind_kph(float maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public void setTotalprecip_mm(float totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public void setAvgvis_km(float avgvis_km) {
        this.avgvis_km = avgvis_km;
    }

    public void setDaily_will_it_rain(float daily_will_it_rain) {
        this.daily_will_it_rain = daily_will_it_rain;
    }

    public void setDaily_will_it_snow(float daily_will_it_snow) {
        this.daily_will_it_snow = daily_will_it_snow;
    }

    public void setCondition(Condition conditionObject) {
        this.ConditionObject = conditionObject;
    }
}
