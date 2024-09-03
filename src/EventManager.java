import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();

    public void addEvent(String name, String date, String location, String type) {
        int id = generateUniqueEventId();
        Event event = new Event(id, name, date, location, type);
        events.add(event);
        System.out.println("Event added successfully.");
    }

    public void updateEvent(int eventId, String name, String date, String location, String type) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                event.setName(name);
                event.setDate(date);
                event.setLocation(location);
                event.setType(type);
                System.out.println("Event updated successfully.");
                return;
            }
        }
        System.out.println("Event not found with ID: " + eventId);
    }

    public void deleteEvent(int eventId) {
        events.removeIf(event -> event.getId() == eventId);
        System.out.println("Event deleted successfully.");
    }

    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void searchEventsByType(String type) {
        boolean found = false;
        for (Event event : events) {
            if (event.getType().equalsIgnoreCase(type)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events found for type: " + type);
        }
    }

    public void searchEventsByDate(String date) {
        boolean found = false;
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events found for date: " + date);
        }
    }

    public void searchEventsByLocation(String location) {
        boolean found = false;
        for (Event event : events) {
            if (event.getLocation().equalsIgnoreCase(location)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events found for location: " + location);
        }
    }

    private int generateUniqueEventId() {
        return (int) (Math.random() * 1000);
    }

    
}
