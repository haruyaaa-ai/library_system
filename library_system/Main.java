package library_system;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            LibrarySystem librarySystem = new LibrarySystem();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nLibrary System Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Exit");
                System.out.println("6. User Management");  // Menu User Management
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    // Existing book-related options
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        librarySystem.addBook(new Book(0, title, author, true));
                        break;

                    case 2:
                        librarySystem.viewBooks();
                        break;

                    case 3:
                        System.out.print("Enter book ID to borrow: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter user ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        librarySystem.borrowBook(bookId, userId);
                        break;

                    case 4:
                        System.out.print("Enter book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        librarySystem.returnBook(returnBookId);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    // New menu for User Management
                    case 6:
                        System.out.println("\nUser Management Menu:");
                        System.out.println("1. Add User");
                        System.out.println("2. View Users");
                        System.out.println("3. Update User");
                        System.out.println("4. Delete User");
                        System.out.print("Choose an option: ");
                        int userOption = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (userOption) {
                            case 1:
                                System.out.print("Enter user name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter user email: ");
                                String email = scanner.nextLine();
                                librarySystem.addUser(new User(0, name, email));
                                break;
                            case 2:
                                librarySystem.viewUsers();
                                break;
                            case 3:
                                System.out.print("Enter user ID to update: ");
                                int uidUpdate = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Enter new name: ");
                                String newName = scanner.nextLine();
                                System.out.print("Enter new email: ");
                                String newEmail = scanner.nextLine();
                                librarySystem.updateUser(uidUpdate, newName, newEmail);
                                break;
                            case 4:
                                System.out.print("Enter user ID to delete: ");
                                int uidDelete = scanner.nextInt(); scanner.nextLine();
                                librarySystem.deleteUser(uidDelete);
                                break;
                            default:
                                System.out.println("Invalid option!");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
