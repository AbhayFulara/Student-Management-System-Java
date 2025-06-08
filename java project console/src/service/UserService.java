package service;

import model.User;
import storage.UserStorage;

public class UserService {
    private UserStorage storage;

    public UserService(UserStorage storage) {
        this.storage = storage;
    }

    public void addUser(User user) {
        if (storage.findById(user.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }
        if (storage.existsByName(user.getName())) {
            System.out.println("Warning: A student with this name already exists.");
        }
        storage.addUser(user);
        System.out.println("Student added successfully.");
    }

    public void displayAll() {
        if (storage.getAllUsers().isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (User u : storage.getAllUsers()) {
            u.display();
            System.out.println("------------------------------");
        }
    }

    public void addMarks(String id, String subject, int mark) {
        User user = storage.findById(id);
        if (user != null) {
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Must be between 0 and 100.");
                return;
            }
            user.addMark(subject, mark);
            System.out.println("Mark added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchById(String id) {
        User user = storage.findById(id);
        if (user != null) {
            user.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteUser(String id) {
        boolean removed = storage.deleteById(id);
        System.out.println(removed ? "Student deleted successfully." : "Student not found.");
    }
}
