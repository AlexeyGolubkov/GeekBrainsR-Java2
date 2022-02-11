
public class Course {

    private int longCircus;
    protected int numbersCircus;

    public Course(int longCircus, int numbersCircus) {
        this.longCircus = longCircus;
        this.numbersCircus = numbersCircus;
    }

    public int getLongCircus() {
        return longCircus;
    }

    public int getNumbersCircus() {
        return numbersCircus;
    }

    public Course() {
        this.longCircus = 400;
        this.numbersCircus = 1;
    }

    protected static void doIt(Team team) {
        int[] TimeForEverMember;
        TimeForEverMember= team.getTimeForEverMember();// if it will need for other a count algorithms of time
        for(int i=0;i< TimeForEverMember.length;i++) {
            TimeForEverMember[i]=25+(int) (7 * (Math.random()));// замеряем, как быстро преодолел участник дистанцию (принимаем минимальное возможное время для покрытия дистанции = 25)
        }
        team.setTimeForEverMembers(TimeForEverMember);
        team.setFinish(true);
    }

}
