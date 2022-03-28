import com.github.javafaker.DateAndTime;

import java.util.List;


interface Student {
    String getName();

    List<Theme> getAllCourses();

    interface Course {
        String getCourse();
        DateAndTime  getDateFinish();
        double getCost();
    }
}