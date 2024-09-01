import java.util.ArrayList;
import java.util.List;

class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private String type;

    public Event(int id, String name, String date, String location, String type) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.type = type;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Event [ID=" + id + ", Name=" + name + ", Date=" + date + ", Location=" + location + ", Type=" + type + "]";
    }
}


class EventManager {
    private List<Event> events = new ArrayList<>();
    private int eventIdCounter = 1;

    public void addEvent(String name, String date, String location, String type) {
        Event event = new Event(eventIdCounter++, name, date, location, type);
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
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
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


