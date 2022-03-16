public class Forecastday {

    private String date;
    Day day;
    Astro astro;
    Hour[] hour;


    // Getter Methods

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
    public Hour[] getHour() {
        return hour;
    }

    public Astro getAstro() {
        return astro;
    }

    // Setter Methods

    public void setDate(String date) {
        this.date = date;
    }

    public void setDay(Day dayObject) {
        this.day = dayObject;
    }

    public void setAstro(Astro astroObject) {
        this.astro = astroObject;
    }
    public void setHour(Hour[] hour) {
        this.hour = hour;
    }
}

