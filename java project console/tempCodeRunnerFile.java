import model.User;
import service.UserService;
import storage.UserStorage;

import java.util.Scanner;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static UserService service = new UserService(new UserStorage());

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

            int choice = Integer.parseInt(sc.nextLine());

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
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Class: ");
        String studentClass = sc.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Total Fee: ");
        double totalFee = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Amount Paid: ");
        double amountPaid = Double.parseDouble(sc.nextLine());

        User user = new User(name, studentClass, studentId, gender, totalFee, amountPaid);
        service.addUser(user);
        System.out.println("Student added successfully.");
    }

    private static void addMarks() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = Integer.parseInt(sc.nextLine());
        service.addMarks(id, subject, marks);
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        service.searchById(id);
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        service.deleteUser(id);
    }
}
