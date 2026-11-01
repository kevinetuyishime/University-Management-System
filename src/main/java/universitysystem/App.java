package universitysystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LearnerDAO learnerDAO = new LearnerDAO();
    private static final SubjectDAO subjectDAO = new SubjectDAO();
    private static final RegistrationDAO registrationDAO = new RegistrationDAO();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            try {
                int choice = readNumber("Choose: ");

                switch (choice) {
                    case 1: addLearner(); break;
                    case 2: listLearners(); break;
                    case 3: removeLearner(); break;
                    case 4: addSubject(); break;
                    case 5: listSubjects(); break;
                    case 6: removeSubject(); break;
                    case 7: registerLearner(); break;
                    case 8: showRegistrations(); break;
                    case 9: changeRegistration(); break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Choose a number from 0 to 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type a number.");
            } catch (SQLException e) {
                System.out.println("Database problem: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Add learner");
        System.out.println("2. List learners");
        System.out.println("3. Remove learner");
        System.out.println("4. Add subject");
        System.out.println("5. List subjects");
        System.out.println("6. Remove subject");
        System.out.println("7. Register learner in subject");
        System.out.println("8. Show learners with their subjects");
        System.out.println("9. Change a registration's subject");
        System.out.println("0. Exit");
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readNumber(String prompt) {
        return Integer.parseInt(readText(prompt));
    }

    private static void addLearner() throws SQLException {
        String name = readText("Name: ");
        String email = readText("Email: ");
        if (name.isEmpty() || !email.contains("@")) {
            System.out.println("Name is required and the email must contain @.");
            return;
        }
        learnerDAO.insert(name, email);
        System.out.println("Learner added.");
    }

    private static void listLearners() throws SQLException {
        List<Learner> learners = learnerDAO.findAll();
        if (learners.isEmpty()) {
            System.out.println("No learners yet.");
        }
        for (Learner l : learners) {
            System.out.println(l.getId() + " - " + l.getName() + " - " + l.getEmail());
        }
    }

    private static void removeLearner() throws SQLException {
        learnerDAO.delete(readNumber("Learner id: "));
        System.out.println("Learner removed.");
    }

    private static void addSubject() throws SQLException {
        String title = readText("Subject title: ");
        if (title.isEmpty()) {
            System.out.println("The title cannot be empty.");
            return;
        }
        subjectDAO.insert(title);
        System.out.println("Subject added.");
    }

    private static void listSubjects() throws SQLException {
        List<Subject> subjects = subjectDAO.findAll();
        if (subjects.isEmpty()) {
            System.out.println("No subjects yet.");
        }
        for (Subject s : subjects) {
            System.out.println(s.getId() + " - " + s.getTitle());
        }
    }

    private static void removeSubject() throws SQLException {
        subjectDAO.delete(readNumber("Subject id: "));
        System.out.println("Subject removed.");
    }

    private static void registerLearner() throws SQLException {
        int learnerId = readNumber("Learner id: ");
        int subjectId = readNumber("Subject id: ");
        registrationDAO.enroll(learnerId, subjectId);
        System.out.println("Registered.");
    }

    private static void showRegistrations() throws SQLException {
        List<String> lines = registrationDAO.findReport();
        if (lines.isEmpty()) {
            System.out.println("No registrations yet.");
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void changeRegistration() throws SQLException {
        int registrationId = readNumber("Registration id: ");
        int newSubjectId = readNumber("New subject id: ");
        registrationDAO.changeSubject(registrationId, newSubjectId);
        System.out.println("Registration updated.");
    }
}