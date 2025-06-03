import java.util.Map;

public interface LibraryOperations {
    Map<String, Book> getBooks();
    Reader getReader();
    Book newBook();
    Book lendBook();
    Book takeBackBook();
    Book showBook();
}
