package ex07.mode1;
import java.util.ArrayList;
import java.util.List;
public class Timetable
{
    private List<Event> events;

    public Timetable() {
        events = new ArrayList<>();
    }

   /* public void addEvent(Event newEvent)
   {
        events.add(newEvent);
    }
    This is the simplest way of adding. But it will not check if there"s any wrong input or
    time collision with other event or duplicate like one event twice.*/


    public boolean addEvent(Event newEvent)  //Adding by checking .
    {
        // Check for duplicate shorthand
        for (Event e : events)
        {
            if (e.getShorthand().equalsIgnoreCase(newEvent.getShorthand()))
            {
                System.out.println("Shorthand already exists: " + newEvent.getShorthand());
                return false;
            }
        }

        // Check for time conflict
        for (EventOccurrence newTime : newEvent.getOccurrences())
        {
            for (Event e : events)
            {
                if (e.takesPlaceAt(newTime))
                {
                    System.out.println("Time conflict at: " + newTime);
                    return false;
                }
            }
        }

        // If no problems, add the event
        events.add(newEvent);
        return true;
    }

    // Remove an event by shorthand
    public boolean removeEvent(String shorthand)
    {
        return events.removeIf(event -> event.getShorthand().equalsIgnoreCase(shorthand));
    }

    // Get a specific event by shorthand
    public Event getEvent(String shorthand)
    {
        for (Event event : events) {
            if (event.getShorthand().equalsIgnoreCase(shorthand))
            {
                return event;
            }
        }
        return null;
    }

    // Get all events (used for export or listing)
    public List<Event> getAllEvents()
    {
        return events;
    }
}
