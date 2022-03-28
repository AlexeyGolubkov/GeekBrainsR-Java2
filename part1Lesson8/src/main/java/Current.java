public class Current {
    private float temp_c;
    Condition ConditionObject;
    private float wind_kph;
    private String wind_dir;
    private float humidity;
    private float vis_km;
    private float uv;


    // Getter Methods

    public float getTemp_c() {
        return temp_c;
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

    public float getHumidity() {
        return humidity;
    }

    public float getVis_km() {
        return vis_km;
    }

    public float getUv() {
        return uv;
    }

    // Setter Methods

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
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

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setVis_km(float vis_km) {
        this.vis_km = vis_km;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }
}
