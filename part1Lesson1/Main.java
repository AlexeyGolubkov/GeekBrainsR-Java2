//* 1
/*2
** 3
 */
public class Main {

    public static void main(String[] args) {
        Course c = new Course(500,5); // Создаем полосу препятствий
        Team team = new Team(); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты

       if(team.getFinish()){
           System.out.println("Команда: \""+team.getName()+"\" финишировала успешно");
       }
        System.out.println("Всего команд участников: "+ team.getNumbersTeams());
    }

}
