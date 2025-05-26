package ex07.mode1;

import ex07.enums.EventType;
import java.util.ArrayList;
import java.util.List;
public class Event
{
    private String shorthand;
    private String name;
    private EventType type;
    private String teacher;
    private List<EventOccurrence> occurrences;

    public Event(String shorthand, String name, EventType type, String teacher)
    {                           //to pass the values of those variables from the main method
        this.shorthand = shorthand;
        this.name = name;
        this.type = type;
        this.teacher = teacher;
        this.occurrences = new ArrayList<>();
    }

    //We used 5 getter method to access the value of the 5 private variables to use outside of this class.
    public String getShorthand()
    { return shorthand; }
    public String getName()
    { return name; }
    public EventType getType()
    { return type; }
    public String getTeacher()
    { return teacher; }
    public List<EventOccurrence> getOccurrences()
    { return occurrences; }

    /*We assumed the first 4 variables as fixed value. So we will not use any setter method-
    for those to make those variable as unchangeable. But for Occurrences, as we will build
    it over time, like we will fix the time continuosly, so we need a setter method for this.
    but we will use some condition so that everyone can't change it as whatever they want.
     */

    public void addOccurrence(EventOccurrence occurrence)   //Setter method for occurrences.
    {
        occurrences.add(occurrence);
    }

    /* The getter method "getOccurrences()" provide us the full time slots of a specific event.
    But it dont check if an event time is colliding with another event or not.
     */
    public boolean takesPlaceAt(EventOccurrence occurrence)
    {
        return occurrences.contains(occurrence);
    }


    @Override
    public String toString()         //to show the full output
    {
        String output = "[" + shorthand + "] Event Info:\n";
        output += "  Name: " + name + "\n";
        output += "  Type: " + type + "\n";
        output += "  Teacher: " + teacher + "\n";
        output += "  Occurrences: ";

        for (int i = 0; i < occurrences.size(); i++)
        {
            if (i > 0)
            {
                output += ", "; // add comma between multiple occurrences
            }
            output += occurrences.get(i); // it will automatically call toString() of EventOccurrence
        }

        return output;
    }
}
