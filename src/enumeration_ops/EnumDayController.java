package enumeration_ops;

// Create an enumeration. Use a controller class to demonstrate the use of the enum from a separate class.
public class EnumDayController {
    static Day day = Day.FRIDAY;

    public static void main(String[] args){

        // list the days
        for (var d: Day.values()) {
            System.out.println(getDay(d) + " -> " + d.name());
        }

    }

    public static String getDay(Day day) {
        return  switch(day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY,FRIDAY -> "WeekDay";
            case SUNDAY, SATURDAY -> "Weekend";
        };
    }


}
