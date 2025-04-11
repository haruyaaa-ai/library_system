package library_system;
public interface LibraryOperations {
    // CRUD Buku
    void addBook(Book book);
    void viewBooks();
    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);
    
    // CRUD Pengguna
    void addUser(User user);
    void viewUsers();
    void updateUser(int userId, String newName, String newEmail);
    void deleteUser(int userId);
}


