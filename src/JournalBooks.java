public class JournalBooks extends Book{


    public JournalBooks(int bookId, String author, String name, Integer price, Boolean status, String edition, String dateOfPurchase, BookServices bookServices, String currentReader) {
        super(bookId, author, name, price, status, edition, dateOfPurchase, bookServices, currentReader);
    }
}
