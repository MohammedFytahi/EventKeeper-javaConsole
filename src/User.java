import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private List<Event> registeredEvents = new ArrayList<>();

    public User(int id, String name, String email) {
        super(id, name, email);
    }

    public void listEvents(EventManager eventManager) {
        eventManager.listEvents();
    }

    public void searchEventsByType(EventManager eventManager, String type) {
        eventManager.searchEventsByType(type);
    }

    public void searchEventsByDate(EventManager eventManager, String date){
        eventManager.searchEventsByDate(date);
    }
    public void searchEventsByLocation(EventManager eventManager, String location) {
        eventManager.searchEventsByLocation(location);
    }
    

    public void listParticipants(ParticipantManager participantManager) {
        participantManager.listParticipants();
    }

    public void registerForEvent(EventManager eventManager, int eventId) {
        Event event = eventManager.getEventById(eventId);
        if (event != null) {
            registeredEvents.add(event);
            System.out.println("Registered for event: " + event);
        } else {
            System.out.println("Event not found with ID: " + eventId);
        }
    }

    public void listRegisteredEvents() {
        if (registeredEvents.isEmpty()) {
            System.out.println("No registered events.");
        } else {
            System.out.println("Registered Events:");
            for (Event event : registeredEvents) {
                System.out.println(event);
            }
        }
    }
}
