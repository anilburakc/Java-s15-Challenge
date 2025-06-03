import java.util.List;
import java.util.Map;

public class Library implements LibraryOperations{
    private Map<String, Book> books;
    private List<Reader> readers;
    private static Library instance = new Library();
    private Library(){}

    public static Library getInstance(){
        return instance;
    }


    @Override
    public Map<String, Book> getBooks() {
        return Map.of();
    }

    @Override
    public Reader getReader() {
        return null;
    }

    @Override
    public Book newBook() {
        return null;
    }

    @Override
    public Book lendBook() {
        return null;
    }

    @Override
    public Book takeBackBook() {
        return null;
    }

    @Override
    public Book showBook() {
        return null;
    }
}
