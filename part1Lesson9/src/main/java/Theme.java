import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

public class Theme implements Student.Course {
    private String theme;
    private DateAndTime dataFinishOfTheme;
    private double cost;
private Faker faker=new Faker();
    public Theme() {

        this.theme = faker.lorem().sentence(2, 5);;
        this.dataFinishOfTheme = faker.date();
        this.cost = Math.round(1000*Math.random());
    }

    @Override
    public String getCourse() {
        return theme;
    }

    @Override
    public DateAndTime getDateFinish() {
        return dataFinishOfTheme;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
