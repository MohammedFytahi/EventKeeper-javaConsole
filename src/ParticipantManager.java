import java.util.ArrayList;
import java.util.List;

class ParticipantManager {
    private List<Person> participants = new ArrayList<>();
    private int nextParticipantId = 1;

    public void addParticipant(String name, String email) {
        Person participant = new Person(nextParticipantId++, name, email);
        participants.add(participant);
        System.out.println("Participant added: " + participant);
    }

    public void updateParticipant(int id, String name, String email) {
        for (Person participant : participants) {
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
        for (Person participant : participants) {
            System.out.println(participant);
        }
    }
}
