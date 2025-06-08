# Student-Management-System-Java
Project Overview:

The Student Management System is a Java-based console application that helps manage student records including personal details, academic marks, and fee payments. It is designed with modular principles and strong input validation, making it an ideal educational project for practicing object-oriented programming.

Project Structure:

 model/User.java                         # Defines the User (Student) object with data and display methods
 
 service/ UserService.java               # Contains core business logic (Add, Search, Delete, Add Marks)
 
 storage/ UserStorage.java               # Stores and manages user records using a dynamic list
 
 main class/ StudentManagement.java      # Main class with menu-driven interface and input handling

Features:

- Add new students with details like name, class, gender, ID, and fee info.

- View all student records neatly formatted.

- Add subject-wise marks with validation (0–100 only).

- Search a student using their ID.

- Delete a student record with confirmation.

- Calculate and display pending fees automatically.

- Strong input validation for numeric and text fields.

- Prevent duplicate student IDs and warn on duplicate names.

- Layered architecture: Model → Service → Storage

- Easy to extend with GUI or database in future.

Technologies Used:

Java (JDK 17),
VS Code or IntelliJ,
Also used java oops principle like encapsulation, abstraction.

 Future Enhancements (Suggestions)

- Store data permanently using file or database integration.

- Add GUI using JavaFX or Swing.

- Generate student reports (PDF/CSV).

- Add user login system for security.




