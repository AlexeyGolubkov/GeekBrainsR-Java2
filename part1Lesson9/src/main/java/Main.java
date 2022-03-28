
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static List<BackGroundStudent> threeSmartestStudents;
    public static void main(String[] args) {
        threeSmartestStudents=new ArrayList<>();
        ArrayList<BackGroundStudent> students = new ArrayList<>() ;
        /*
         * if insufficient memory for the Java Runtime Environment need do less "k"
         */
        int k=40;
        for(int i=0;i<k;i++) {
            students.add(new BackGroundStudent());
        }
        int i=0;

        System.out.println("The smartest list:");
        for(BackGroundStudent student:  smartestStudents(students,i )){

            System.out.println(student.toString());
        }
        String course = threeSmartestStudents.get(0).getAllCourses().get(0).getCourse();
        
        System.out.println("\nИскомый курс: "+"\""+course+"\" есть у следующих студентов:");

        for (BackGroundStudent student: findAllStudentCourse(threeSmartestStudents, course)){
            System.out.println(student);
        }
        System.out.println();
        System.out.println("У запрошенного списка студентов следующие уникальные темы курсов:");
        System.out.println(uniqueCoursesStudents(threeSmartestStudents));
    }




    private static List<BackGroundStudent> smartestStudents(ArrayList<BackGroundStudent> students, int i) {
        if (i>2) {return threeSmartestStudents;}

        List<BackGroundStudent> list= students.stream()
                                              .reduce((groundStudent1, groundStudent2) ->
                                                      groundStudent1.getAllCourses().size() > groundStudent2.getAllCourses().size() ?
                                                              groundStudent1 : groundStudent2).stream().collect(Collectors.toList());


        threeSmartestStudents.addAll(list);
        students.removeAll(list);
        i++;
        if(students.isEmpty()){return threeSmartestStudents;}
        smartestStudents(students,i );
        return threeSmartestStudents;
    }
    private static List<BackGroundStudent> findAllStudentCourse(List<BackGroundStudent> threeSmartestStudents, String course) {
        return threeSmartestStudents.stream().filter(s->s.findTheme(course)).collect(Collectors.toList());
    }
    public static Set<String> uniqueCoursesStudents(List<BackGroundStudent> students){
        Set<String> uniqueThemeStudents = new TreeSet<>();
        for(BackGroundStudent student: students){
            uniqueThemeStudents.addAll(student.getUniqueTheme());
        }

        return uniqueThemeStudents;

    }

}




