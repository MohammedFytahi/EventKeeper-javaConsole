import java.util.ArrayList;
import java.util.List;

public class Participant {
    private int id;
    private String name;
    private String email;

    public Participant(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Participant [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }

   
    public static void addParticipant(List<Participant> participants, int participantIdCounter, String name, String email) {
        Participant participant = new Participant(participantIdCounter++, name, email);
        participants.add(participant);
        System.out.println("Participant added: " + participant);
    }

    public static void updateParticipant(List<Participant> participants, int id, String name, String email) {
        for (Participant participant : participants) {
            if (participant.getId() == id) {
                participant.setName(name);
                participant.setEmail(email);
                System.out.println("Participant updated: " + participant);
                return;
            }
        }
        System.out.println("Participant not found with ID: " + id);
    }

    public static void deleteParticipant(List<Participant> participants, int id) {
        participants.removeIf(participant -> participant.getId() == id);
        System.out.println("Participant deleted with ID: " + id);
    }

    public static void listParticipants(List<Participant> participants) {
        if (participants.isEmpty()) {
            System.out.println("No participants found.");
        } else {
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        }
    }
}

class ParticipantManager {
    private List<Participant> participants = new ArrayList<>();
    private int participantIdCounter = 1;

    public void addParticipant(String name, String email) {
        Participant participant = new Participant(participantIdCounter++, name, email);
        participants.add(participant);
        System.out.println("Participant added: " + participant);
    }

    public void updateParticipant(int id, String name, String email) {
        for (Participant participant : participants) {
            if (participant.getId() == id) {
                participant.setName(name);
                participant.setEmail(email);
                System.out.println("Participant updated: " + participant);
                return;
            }
        }
        System.out.println("Participant not found with ID: " + id);
    }

    public void deleteParticipant(int id) {
        participants.removeIf(participant -> participant.getId() == id);
        System.out.println("Participant deleted with ID: " + id);
    }

    public void listParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants found.");
        } else {
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        }
    }
}