import java.util.Map;
import java.util.Objects;

public class Author extends Person{
    private Map<String, Book> books;
    public Author(String name) {
        super(name);
    }

    @Override
    public void whoAreYou() {
        System.out.println("Ben yazarim.");
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
        for(Book b: books.values()){
            if(b.getAuthor().contains(authorName)){
                System.out.println("Author: " + authorName + " Books: " + b);
            }else {
                System.out.println("yazara ait kitap bulunamadi!");
            }
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
