import java.util.Map;

public class Author extends Person{
    private Map<String, Book> books;
    public Author(String name) {
        super(name);
    }

    @Override
    public void whoAreYou() {

    }

    public void newBook(){}
    public void showBook(){}
}
