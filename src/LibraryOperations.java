import java.util.Map;

public interface LibraryOperations {
    Map<String, Book> getBooks();

    Reader getReaders(String readerId);

    void newBook(String key, Book book);

    //void lendBook(String bookName, String readerName);

    //void takeBackBook(String bookName);

    void showBook();
    //void removeBook(String id);

    //void updateBook(String id, Book updatedBook);

    //void listBooksByCategory(String category);
}
