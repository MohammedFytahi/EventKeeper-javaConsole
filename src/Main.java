import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static EventManager eventManager = new EventManager();
    private static ParticipantManager participantManager = new ParticipantManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        Admin admin = new Admin(1, "Admin", "admin@example.com", eventManager, participantManager);

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
                    User user = registerUser(scanner);
                    if (user != null) {
                        userMenu(scanner, user, eventManager);
                    }
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

    private static User registerUser(Scanner scanner) {
        System.out.println("\n=== User Registration ===");
        String name;
        String email;

        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            }
        } while (name.isEmpty());

        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        } while (!isValidEmail(email));

        int userId = generateUniqueUserId();
        User user = new User(userId, name, email);
        System.out.println("User registered successfully with ID: " + userId);
        return user;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    private static int generateUniqueUserId() {
        return (int) (Math.random() * 1000);
    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        int choice;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. List Events");
            System.out.println("5. Search Events");
            System.out.println("6. Add Participant");
            System.out.println("7. Update Participant");
            System.out.println("8. Delete Participant");
            System.out.println("9. List Participants");
            System.out.println("10. Generate Report");
            System.out.println("11. Back to Main Menu");
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
                    if (isValidDate(date)) {
                        admin.addEvent(name, date, location, type);
                    } else {
                        System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
                    }
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
                    if (isValidDate(date) && eventId > 0) {
                        admin.updateEvent(eventId, name, date, location, type);
                    } else {
                        System.out.println("Invalid input. Ensure the date format is yyyy-mm-dd and ID is positive.");
                    }
                    break;
                case 3:
                    System.out.print("Enter event ID to delete: ");
                    eventId = scanner.nextInt();
                    scanner.nextLine();
                    if (eventId > 0) {
                        admin.deleteEvent(eventId);
                    } else {
                        System.out.println("Event ID must be a positive number.");
                    }
                    break;
                case 4:
                    admin.listEvents();
                    break;
                case 5:
                    searchMenu(scanner, admin);
                    break;
                case 6:
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();
                    System.out.print("Enter participant email: ");
                    String email = scanner.nextLine();
                    if (!participantName.isEmpty() && isValidEmail(email)) {
                        admin.addParticipant(participantName, email);
                    } else {
                        System.out.println("Invalid name or email format.");
                    }
                    break;
                case 7:
                    System.out.print("Enter participant ID to update: ");
                    int participantId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new participant name: ");
                    participantName = scanner.nextLine();
                    System.out.print("Enter new participant email: ");
                    email = scanner.nextLine();
                    if (!participantName.isEmpty() && isValidEmail(email) && participantId > 0) {
                        admin.updateParticipant(participantId, participantName, email);
                    } else {
                        System.out.println("Invalid input. Ensure name is not empty, email is valid, and ID is positive.");
                    }
                    break;
                case 8:
                    System.out.print("Enter participant ID to delete: ");
                    participantId = scanner.nextInt();
                    scanner.nextLine();
                    if (participantId > 0) {
                        admin.deleteParticipant(participantId);
                    } else {
                        System.out.println("Participant ID must be a positive number.");
                    }
                    break;
                case 9:
                    admin.listParticipants();
                    break;
                case 10:
                    admin.generateReport();
                    break;
                case 11:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);
    }

    private static void searchMenu(Scanner scanner, Admin admin) {
        int choice;
        do {
            System.out.println("\n=== Search Menu ===");
            System.out.println("1. Search Events by Type");
            System.out.println("2. Search Events by Date");
            System.out.println("3. Search Events by Location");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter event type to search: ");
                    String type = scanner.nextLine();
                    admin.searchEventsByType(type);
                    break;
                case 2:
                    System.out.print("Enter event date to search (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    admin.searchEventsByDate(date);
                    break;
                case 3:
                    System.out.print("Enter event location to search: ");
                    String location = scanner.nextLine();
                    admin.searchEventsByLocation(location);
                    break;
                case 4:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void userMenu(Scanner scanner, User user, EventManager eventManager) {
        int choice;
        do {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. List Events");
            System.out.println("2. Search Events");
            System.out.println("3. Register for an Event");
            System.out.println("4. List Registered Events");
            System.out.println("5. Unregister from an Event");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.listEvents(eventManager);
                    break;
                case 2:
                    searchMenu(scanner, user, eventManager);
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
                    System.out.print("Enter event ID to unregister from: ");
                    eventId = scanner.nextInt();
                    scanner.nextLine();
                    user.unregisterFromEvent(eventManager, eventId);
                    break;
                case 6:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void searchMenu(Scanner scanner, User user, EventManager eventManager) {
        int choice;
        do {
            System.out.println("\n=== Search Menu ===");
            System.out.println("1. Search Events by Type");
            System.out.println("2. Search Events by Date");
            System.out.println("3. Search Events by Location");
            System.out.println("4. Back to User Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter event type to search: ");
                    String type = scanner.nextLine();
                    user.searchEventsByType(eventManager, type);
                    break;
                case 2:
                    System.out.print("Enter event date to search (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    user.searchEventsByDate(eventManager, date);
                    break;
                case 3:
                    System.out.print("Enter event location to search: ");
                    String location = scanner.nextLine();
                    user.searchEventsByLocation(eventManager, location);
                    break;
                case 4:
                    System.out.println("Returning to User Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static boolean isValidDate(String date) {
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(dateRegex, date);
    }
}
