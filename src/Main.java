import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}


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


class User extends Person {
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
            for (Event event : registeredEvents) {
                System.out.println(event);
            }
        }
    }
}




public class Main {
    private static EventManager eventManager = new EventManager();
    private static ParticipantManager participantManager = new ParticipantManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

 
        Admin admin = new Admin(1, "Admin", "admin@example.com", eventManager, participantManager);
        User user = new User(2, "User", "user@example.com");

        do {
            System.out.println("\n=== Event Management System ===");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Quit");
            System.out.print("Choose your role: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    adminMenu(scanner, admin);
                    break;
                case 2:
                    userMenu(scanner, user);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        scanner.close();
    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        int choice;
        do {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. List Events");
       
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter event date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter event type: ");
                    String type = scanner.nextLine();
                    admin.addEvent(name, date, location, type);
                    break;
                case 2:
                    System.out.print("Enter event ID to update: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new event name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new event date (yyyy-mm-dd): ");
                    date = scanner.nextLine();
                    System.out.print("Enter new event location: ");
                    location = scanner.nextLine();
                    System.out.print("Enter new event type: ");
                    type = scanner.nextLine();
                    admin.updateEvent(eventId, name, date, location, type);
                    break;
                case 3:
                    System.out.print("Enter event ID to delete: ");
                    eventId = scanner.nextInt();
                    scanner.nextLine(); 
                    admin.deleteEvent(eventId);
                    break;
                case 4:
                    admin.listEvents();
                    break;
                case 5:
                    System.out.print("Enter event type to search: ");
                    type = scanner.nextLine();
                    admin.searchEventsByType(type);
                    break;
                case 6:
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();
                    System.out.print("Enter participant email: ");
                    String email = scanner.nextLine();
                    admin.addParticipant(participantName, email);
                    break;
                case 7:
                    System.out.print("Enter participant ID to update: ");
                    int participantId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new participant name: ");
                    participantName = scanner.nextLine();
                    System.out.print("Enter new participant email: ");
                    email = scanner.nextLine();
                    admin.updateParticipant(participantId, participantName, email);
                    break;
                case 8:
                    System.out.print("Enter participant ID to delete: ");
                    participantId = scanner.nextInt();
                    scanner.nextLine(); 
                    admin.deleteParticipant(participantId);
                    break;
                case 9:
                    admin.listParticipants();
                    break;
                case 10:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
    }

    private static void userMenu(Scanner scanner, User user) {
        int choice;
        do {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. List Events");
           
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    user.listEvents(eventManager);
                    break;
                case 2:
                    System.out.print("Enter event type to search: ");
                    String type = scanner.nextLine();
                    user.searchEventsByType(eventManager, type);
                    break;
                case 3:
                    System.out.print("Enter event ID to register for: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine(); 
                    user.registerForEvent(eventManager, eventId);
                    break;
                case 4:
                    user.listRegisteredEvents();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
