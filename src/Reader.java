import java.util.*;

public class Reader extends Person{
    //private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();

    public Reader(String name) {
        super(name);
    }


    @Override
    public void whoAreYou() {
        System.out.println("Reader");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(readers, reader.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(readers);
    }

    public Reader(String name, List<Reader> readers) {
        super(name);
        this.readers = readers;
    }


    public void purchaseBook(String bookId, String readerName){
        Map<String, Book> allBooks = Library.getInstance().getBooks();
        if(!allBooks.containsKey(bookId)){
            System.out.println("kitap bulunamadi");
            return;
        }

        Book book = allBooks.get(bookId);

        if(!book.getStatus()){
            System.out.println("bu kitap zaten alinmis");
            return;
        }
        MemberRecord member = Library.getInstance().findMemberByName(readerName);
        if(member == null){
            System.out.println("'" + readerName + "' isimli üye bulunamadı");
            return;
        }


        book.setCurrentReader(readerName);
        allBooks.remove(bookId);

        BillingService billingService = new BillingService();

        int bill = book.getPrice();
        System.out.println(readerName + " kitabi satin aldi. Fatura: " + bill);
    }

    public void barrowBook(String bookName, String readerName) {
        Map<String, Book> allBooks = Library.getInstance().getBooks();
        for(Book b: allBooks.values()){
            if(b.getName().equalsIgnoreCase(bookName)){
                if(b.getStatus() == false){
                    System.out.println("bu kitap baskasinda");
                    return;
                }
                MemberRecord member = Library.getInstance().findMemberByName(readerName);

                if(member == null){
                    System.out.println("uye yok");
                    return;
                }

                if (member.hasReachedLimit()){
                    System.out.println("limitiniz doldu");
                    return;
                }

                b.setStatus(false);
                b.setCurrentReader(readerName);
                member.incBookIssued(member.getMemberId());
                System.out.println("islem basariyla gerceklesti");
                return;
            }
        }

        System.out.println("kitap yok");
    }
    public void returnBook(String bookName, String readerName) {
        MemberRecord member = Library.getInstance().findMemberByName(readerName);
        if(member == null){
            System.out.println("uye bulunamadi");
            return;
        }

        Map<String, Book> allBooks = Library.getInstance().getBooks();
        for(Book b: allBooks.values()){
            if(b.getName().equalsIgnoreCase(bookName)){
                if(b.getStatus() == false && readerName.equalsIgnoreCase(b.getCurrentReader())){
                    b.setStatus(true);
                    b.setCurrentReader(null);
                    member.decBookIssued(member.getMemberId());
                    System.out.println("kitap iade edildi");
                    System.out.println("Güncel kitap sayınız: " + member.getNoBooksIssued());
                    return;
                }else {
                    System.out.println("kitap kutuphanede");
                    return;
                }

            }
        }
        System.out.println("kitap bulunamadi");
    }
    public void showBook(String reader){
        Map<String, Book> allBooks = Library.getInstance().getBooks();
        boolean found = false;
        for(Book b: allBooks.values()){
            if(b.getCurrentReader().equals(reader)){
                System.out.println("reader: " + reader + " Books: " + b);
                found = true;
            }

        }
        if (!found){
            System.out.println("okuyucuya ait kitap bulunamadi!");
        }
    }

    public void listBooksByCategory(String category) {
        Map<String, Book> allBooks = Library.getInstance().getBooks();
        boolean found = false;
        for(Book b: allBooks.values()){
            if(category.equalsIgnoreCase("study") && b instanceof StudyBooks){
                System.out.println("study books: " + b);
                found = true;
            } else if (category.equalsIgnoreCase("journal") && b instanceof JournalBooks) {
                System.out.println("journal books: " + b);
                found = true;
            }else if (category.equalsIgnoreCase("magazine") && b instanceof MagazineBooks) {
                System.out.println("magazine books: " + b);
                found = true;
            }
        }
        if (!found){
            System.out.println("boyle bir kategori yok.");
        }

    }

    @Override
    public String toString() {
        return "Reader{" +
                //"books=" + books +
                '}';
    }
}
