import java.util.Map;
import java.util.Objects;

public class Book {
    private int bookId;
    private String author;
    private String name;
    private Integer price;
    private Boolean status;
    private String edition;
    private String dateOfPurchase;
    private BookServices bookServices;
    private String currentReader;

    public Book(int bookId, String author, String name, Integer price, Boolean status, String edition, String dateOfPurchase, BookServices bookServices, String currentReader) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.bookServices = bookServices;
        this.currentReader = currentReader;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public BookServices getBookServices() {
        return bookServices;
    }

    public void setBookServices(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    public String getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(String currentReader) {
        this.currentReader = currentReader;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Objects.equals(author, book.author) && Objects.equals(name, book.name) && Objects.equals(price, book.price) && Objects.equals(status, book.status) && Objects.equals(edition, book.edition) && Objects.equals(dateOfPurchase, book.dateOfPurchase) && Objects.equals(currentReader, book.currentReader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, name, price, status, edition, dateOfPurchase, currentReader);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", currentReader='" + currentReader + '\'' +
                '}';
    }
}
