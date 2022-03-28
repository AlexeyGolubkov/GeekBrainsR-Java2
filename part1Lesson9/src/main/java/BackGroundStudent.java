import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BackGroundStudent implements Student {
    private String name;
    private List<Theme> courses;

    private Faker faker = new Faker();

    public BackGroundStudent() {
        this.name = faker.name().fullName();
        List<Theme> list = new ArrayList();
        int i = 1 + (int)(10* Math.random());
 //       System.out.println(name+" прошёл всего курсов "+i);
        for (int k=i; i > 0; i--) {

            Theme course = new Theme();

            list.add(course);
        }
        this.courses = list;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Theme> getAllCourses() {
        return courses;
    }

    @Override
    public String toString() {
        String str="";
        double sum=0;
        String name=getName();
        int i=0;
        for (Theme course : getAllCourses()){

            str+=course.getCourse()+";";
            sum+=course.getCost();
            i++;
        }
        return "Student is name "+name+" закончил следующие курсы:\n"+str+"\nВсего "+i+" курсов. Общей стоимостью $"+sum;
    }
    public boolean findTheme(String course){
        for(Theme theme:getAllCourses()){
            if(theme.getCourse().equals(course)){return true;}
        }
        return false;
    }
    public List<String> getUniqueTheme(){
        return getAllCourses().stream().map(g->g.getCourse()).collect(Collectors.toList());
    }
}
