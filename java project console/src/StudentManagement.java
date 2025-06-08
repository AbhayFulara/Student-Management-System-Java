import model.User;
import service.UserService;
import storage.UserStorage;

import java.util.Scanner;

public class StudentManagement {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService service = new UserService(new UserStorage());

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Marks to Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Select option: ");

            int choice = readInt("Enter your choice (1-6): ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> service.displayAll();
                case 3 -> addMarks();
                case 4 -> searchStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        String name = readNonEmptyString("Enter Name: ");
        String studentClass = readNonEmptyString("Enter Class: ");
        String studentId = readNonEmptyString("Enter Student ID: ");
        String gender = readNonEmptyString("Enter Gender (Male/Female/Other): ");

        double totalFee = readDouble("Enter Total Fee: ");
        double amountPaid = readDouble("Enter Amount Paid: ");

        if (amountPaid > totalFee) {
            System.out.println("Amount paid cannot be greater than total fee.");
            return;
        }

        User user = new User(name, studentClass, studentId, gender, totalFee, amountPaid);
        service.addUser(user);
    }

    private static void addMarks() {
        String id = readNonEmptyString("Enter Student ID: ");
        int subjectCount = readInt("Enter number of subjects: ");

        for (int i = 0; i < subjectCount; i++) {
            String subject = readNonEmptyString("Enter Subject " + (i + 1) + " Name: ");
            int marks = readInt("Enter Marks for " + subject + " (0-100): ", 0, 100);
            service.addMarks(id, subject, marks);
        }
    }

    private static void searchStudent() {
        String id = readNonEmptyString("Enter Student ID: ");
        service.searchById(id);
    }

    private static void deleteStudent() {
        String id = readNonEmptyString("Enter Student ID to delete: ");
        service.deleteUser(id);
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine());
                if (value < 0) {
                    System.out.println("Please enter a non-negative number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static int readInt(String message, int min, int max) {
        while (true) {
            int num = readInt(message);
            if (num < min || num > max) {
                System.out.println("Value must be between " + min + " and " + max + ".");
                continue;
            }
            return num;
        }
    }

    private static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }
}

