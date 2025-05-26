package ex07.mode1;
import ex07.enums.Weekday;
import java.util.Objects;

public class EventOccurrence
{
    private Weekday day;
    private int hour;

    public EventOccurrence(Weekday day, int hour) {
        this.day = day;
        this.hour = hour;
    }

    public Weekday getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventOccurrence)) return false;
        EventOccurrence that = (EventOccurrence) o;
        return hour == that.hour && day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, hour);
    }

    @Override
    public String toString() {
        return day + "" + hour;
    }

}
