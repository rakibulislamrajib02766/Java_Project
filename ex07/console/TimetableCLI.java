package ex07.console;

import ex07.enums.EventType;
import ex07.enums.Weekday;
import ex07.mode1.Event;
import ex07.mode1.EventOccurrence;
import ex07.mode1.Timetable;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class TimetableCLI
{   private final Scanner consoleIn;
    private final PrintStream consoleOut;
    private final Timetable timetable;

        public TimetableCLI(PrintStream consoleOut, Scanner consoleIn)
        {
            this.consoleOut = consoleOut;
            this.consoleIn = consoleIn;
            this.consoleIn.useDelimiter("\n");
            this.consoleIn.useLocale(Locale.ENGLISH);
            this.timetable = new Timetable();
        }

        public static void main(String[] args) {
            new TimetableCLI(System.out, new Scanner(System.in)).run();
        }

        public void run() {
            boolean running = true;
            while (running) {
                running = showMainMenu();
            }
        }

        private boolean showMainMenu() {
            consoleOut.println("""
    (1) Show current timetable
    (2) Show details of an event
    (3) Add an event
    (4) Delete an event
    (5) Export to file (Coming soon)
    (6) Import from file (Coming soon)
    (9) Exit
    """);

            if (consoleIn.hasNextInt()) {
                switch (consoleIn.nextInt()) {
                    case 1 -> showTimetable();
                    case 2 -> showEventDetails();
                    case 3 -> addEvent();
                    case 4 -> deleteEvent();
                    case 5, 6 -> consoleOut.println("File I/O not implemented yet.");
                    case 9 -> {
                        return false;
                    }
                    default -> consoleOut.println("Invalid option.");
                }
            } else {
                consoleOut.println("Invalid input: " + consoleIn.next());
            }
            return true;
        }

        private void showTimetable() {
            for (Event event : timetable.getAllEvents()) {
                consoleOut.println(event.getShorthand() + " - " + event);
            }
        }

        private void showEventDetails() {
            consoleOut.print("Enter shorthand: ");
            String shorthand = consoleIn.next();
            Event event = timetable.getEvent(shorthand);
            if (event != null) {
                consoleOut.println(event);
            } else {
                consoleOut.println("Event not found.");
            }
        }

        private void addEvent() {
            consoleOut.print("Enter shorthand (max 3 letters): ");
            String shorthand = consoleIn.next().trim();

            consoleOut.print("Enter full name: ");
            String name = consoleIn.next().trim();

            consoleOut.print("Enter type (SEMINAR, EXERCISE, PRACTICAL): ");
            EventType type = EventType.valueOf(consoleIn.next().trim().toUpperCase());

            consoleOut.print("Enter teacher's name: ");
            String teacher = consoleIn.next().trim();

            Event newEvent = new Event(shorthand, name, type, teacher);

            consoleOut.print("How many times does this event occur? (1 to 4): ");
            int count = consoleIn.nextInt();

            for (int i = 0; i < count; i++) {
                consoleOut.print("Enter weekday (MON, TUE, WED, THU, FRI): ");
                Weekday day = Weekday.valueOf(consoleIn.next().trim().toUpperCase());

                consoleOut.print("Enter hour (8, 10, 12, 14, 16, 18): ");
                int hour = consoleIn.nextInt();

                newEvent.addOccurrence(new EventOccurrence(day, hour));
            }

            if (timetable.addEvent(newEvent)) {
                consoleOut.println("Event added successfully!");
            } else {
                consoleOut.println("Could not add event. Conflict or duplicate shorthand.");
            }
        }

        private void deleteEvent() {
            consoleOut.print("Enter shorthand to delete: ");
            String shorthand = consoleIn.next();
            boolean removed = timetable.removeEvent(shorthand);
            if (removed) {
                consoleOut.println("Event removed successfully.");
            } else {
                consoleOut.println("Event not found.");
            }
        }

    }
