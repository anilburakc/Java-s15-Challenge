import java.util.Map;
import java.util.Objects;

public class Reader extends Person{
    private Map<String, Book> books;

    public Reader(String name) {
        super(name);
    }


    @Override
    public void whoAreYou() {
        System.out.println("Reader");
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(books, reader.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }

    public void purchaseBook(Book book, String bookId){
        if(book.getCurrentReader() == null){
            books.remove(bookId);
            System.out.println("islem basariyla gerceklesti");
        }else{
            System.out.println("hatali islem");
        }
    }
    public void borrowBook(String bookName, String readerName){
        for(Book b: books.values()){
            if(b.getName().equals(bookName)){
                if(b.getStatus() == false){
                    System.out.println("bu kitap baskasinda");
                }else {
                    b.setStatus(false);
                    b.setCurrentReader(readerName);
                    System.out.println("kitap alindi");
                }
            }
        }
    }
    public void returnBook(String bookName){
        for(Book b: books.values()){
            if(b.getName().equals(bookName)){
                if(b.getStatus() == false){
                    b.setStatus(true);
                    b.setCurrentReader(null);
                    System.out.println("kitap iade edildi");
                }else {
                    System.out.println("sistem hatasi");
                }
            }
        }
    }
    public void showBook(String reader){
        for(Book b: books.values()){
            if(b.getCurrentReader().equals(reader)){
                System.out.println("reader: " + reader + " Books: " + b);
            }else {
                System.out.println("okuyucuya ait kitap bulunamadi!");
            }
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "books=" + books +
                '}';
    }
}
