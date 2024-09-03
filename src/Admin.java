import java.util.List;

class Admin extends Person {
    private EventManager eventManager;
    private ParticipantManager participantManager;

    public Admin(int id, String name, String email, EventManager eventManager, ParticipantManager participantManager) {
        super(id, name, email);
        this.eventManager = eventManager;
        this.participantManager = participantManager;
    }

    public void addEvent(String name, String date, String location, String type) {
        eventManager.addEvent(name, date, location, type);
    }

    public void updateEvent(int id, String name, String date, String location, String type) {
        eventManager.updateEvent(id, name, date, location, type);
    }

    public void deleteEvent(int id) {
        eventManager.deleteEvent(id);
    }

    public void listEvents() {
        eventManager.listEvents();
    }

    public void searchEventsByType(String type) {
        eventManager.searchEventsByType(type);
    }

    public void addParticipant(String name, String email) {
        participantManager.addParticipant(name, email);
    }

    public void updateParticipant(int id, String name, String email) {
        participantManager.updateParticipant(id, name, email);
    }

    public void deleteParticipant(int id) {
        participantManager.deleteParticipant(id);
    }

    public void listParticipants() {
        participantManager.listParticipants();
    }

    public void generateReport() {
        System.out.println("\n=== Rapport des Événements ===");
        List<Event> events = eventManager.getAllEvents();
        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé.");
        } else {
            for (Event event : events) {
                System.out.println("ID: " + event.getId() + ", Nom: " + event.getName() + ", Date: " + event.getDate() +
                                   ", Lieu: " + event.getLocation() + ", Type: " + event.getType());
            }
        }

        System.out.println("\n=== Rapport des Participants ===");
        List<Person> participants = participantManager.getAllParticipants();
        if (participants.isEmpty()) {
            System.out.println("Aucun participant trouvé.");
        } else {
            for (Person participant : participants) {
                System.out.println("ID: " + participant.getId() + ", Nom: " + participant.getName() + ", Email: " + participant.getEmail());
            }
        }
    }
}