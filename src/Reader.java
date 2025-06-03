import java.util.Map;

public class Reader extends Person{
    private Map<String, Book> books;

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoAreYou() {

    }

    public void purchaseBook(){}
    public void borrowBook(){}
    public void returnBook(){}
    public void showBook(){}
}
