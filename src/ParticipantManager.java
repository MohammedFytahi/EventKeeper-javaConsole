import java.util.ArrayList;
import java.util.List;

class ParticipantManager {
    private List<User> participants;

    public ParticipantManager() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(String name, String email) {
        int userId = generateUniqueUserId();
        User participant = new User(userId, name, email);
        participants.add(participant);
        System.out.println("Participant ajouté avec succès.");
    }

    public void updateParticipant(int id, String name, String email) {
        for (User participant : participants) {
            if (participant.getId() == id) {
                participant.setName(name);
                participant.setEmail(email);
                System.out.println("Participant mis à jour avec succès.");
                return;
            }
        }
        System.out.println("Participant non trouvé.");
    }

    public void deleteParticipant(int id) {
        participants.removeIf(participant -> participant.getId() == id);
        System.out.println("Participant supprimé avec succès.");
    }

    public void listParticipants() {
        if (participants.isEmpty()) {
            System.out.println("Aucun participant trouvé.");
        } else {
            for (User participant : participants) {
                System.out.println("ID: " + participant.getId() + ", Nom: " + participant.getName() + ", Email: " + participant.getEmail());
            }
        }
    }

    public List<Person> getAllParticipants() {
        return new ArrayList<>(participants);  
    }

    private int generateUniqueUserId() {
        return (int) (Math.random() * 1000);
    }
}
