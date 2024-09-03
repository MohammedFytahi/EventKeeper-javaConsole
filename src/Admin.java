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
}