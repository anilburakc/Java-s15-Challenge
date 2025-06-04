public class StudyBooks extends Book{


    public StudyBooks(int bookId, String author, String name, Integer price, Boolean status, String edition, String dateOfPurchase, BookServices bookServices, String currentReader) {
        super(bookId, author, name, price, status, edition, dateOfPurchase, bookServices, currentReader);
    }
}
