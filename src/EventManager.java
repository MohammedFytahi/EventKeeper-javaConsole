import java.util.ArrayList;
import java.util.List;

class EventManager {
    private List<Event> events = new ArrayList<>();
    private int nextEventId = 1;

    public void addEvent(String name, String date, String location, String type) {
        Event event = new Event(nextEventId++, name, date, location, type);
        events.add(event);
        System.out.println("Event added: " + event);
    }

    public void updateEvent(int id, String name, String date, String location, String type) {
        for (Event event : events) {
            if (event.getId() == id) {
                event.setName(name);
                event.setDate(date);
                event.setLocation(location);
                event.setType(type);
                System.out.println("Event updated: " + event);
                return;
            }
        }
        System.out.println("Event not found with ID: " + id);
    }

    public void deleteEvent(int id) {
        events.removeIf(event -> event.getId() == id);
        System.out.println("Event deleted with ID: " + id);
    }

    public void listEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void searchEventsByType(String type) {
        for (Event event : events) {
            if (event.getType().equalsIgnoreCase(type)) {
                System.out.println(event);
            }
        }
    }

    public Event getEventById(int id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }
}
