import java.util.*;

public class Author extends Person{
    private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();
    public Author(String name) {
        super(name);
    }

    @Override
    public void whoAreYou() {
        System.out.println("Ben yazarim.");
    }

    public Author(String name, Map<String, Book> books, List<Reader> readers) {
        super(name);
        this.books = books;
        this.readers = readers;
    }


    public Author(String name, Map<String, Book> books) {
        super(name);
        this.books = books;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }
    public void newBook(String key, Book book, String authorName) {
        if(books.containsKey(key)){
            System.out.println("Bu key mevcut");
        }else if (books.containsValue(book)){
            System.out.println("Bu kitap mevcut");
        }else{
            book.setAuthor(authorName);
            books.put(key, book);
            System.out.println("Kitap basariyla eklendi");
        }
    }
    public void showBook(String authorName){
        boolean found = false;

        for (Book b : books.values()) {
            if (b.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println("Author: " + authorName + " Book: " + b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Yazara ait kitap bulunamadi!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
