import java.util.Map;

public class Book {
    private String bookId;
    private String author;
    private String name;
    private Integer price;
    private Boolean status;
    private String edition;
    private String dateOfPurchase;
    private BookServices bookServices;

    public Book(String bookId, String author, String name, Integer price, Boolean status, String edition, String dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }


}
