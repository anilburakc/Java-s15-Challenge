import java.util.*;

public class Library implements LibraryOperations{
    private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();
    private static Library instance = new Library();
    private Library(){
        initializeMembers();
    }

    private void initializeMembers(){
        BillingService billingService = new BillingService();
        MemberRecord member1 = new MemberRecord("anil", new ArrayList<>(), "M001",
                Type.STUDENT, "2024-01-01", 0, "anil", "İstanbul", 555123456, billingService);
        MemberRecord member2 = new MemberRecord("burak", new ArrayList<>(), "M002",
                Type.FACULTY, "2024-02-01", 0, "burak", "Ankara", 555123457, billingService);

        readers.add(member1);
        readers.add(member2);
    }

    public static Library getInstance(){
        return instance;
    }


    @Override
    public Map<String, Book> getBooks() {
        return Collections.unmodifiableMap(books);
    }

    @Override
    public Reader getReaders(String readerName) {
        for(Reader read: readers){
            if(read.getName().equals(readerName)){
                return read;
            }
        }
        return null;
    }

    @Override
    public void newBook(String key, Book book) {
        if(books.containsKey(key)){
            System.out.println("Bu key mevcut");
        }else if (books.containsValue(book)){
            System.out.println("Bu kitap mevcut");
        }else{
            books.put(key, book);
            System.out.println("Kitap basariyla eklendi");
        }
    }

    @Override
    public void lendBook(String bookName, String readerName) {
        for(Book b: books.values()){
            if(b.getName().equalsIgnoreCase(bookName)){
                if(b.getStatus() == false){
                    System.out.println("bu kitap baskasinda");
                    return;
                }
                MemberRecord member = findMemberByName(readerName);

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

    @Override
    public void takeBackBook(String bookName) {
        for(Book b: books.values()){
            if(b.getName().equalsIgnoreCase(bookName)){
                if(b.getStatus() == false){
                    String readerName = b.getCurrentReader();
                    b.setStatus(true);
                    b.setCurrentReader(null);
                    System.out.println("kitap iade edildi");

                    for (Reader reader: readers){
                        if(reader.getName().equalsIgnoreCase(readerName) && reader instanceof MemberRecord){
                            MemberRecord m = (MemberRecord) reader;
                            m.decBookIssued(m.getMemberId());
                            System.out.println("sahip olunan kitap: " + m.getNoBooksIssued());
                        }
                    }
                }else {
                    System.out.println("kitap kutuphanede");
                }
                return;
            }
        }
        System.out.println("kitap bulunamadi");
    }

    public MemberRecord findMemberByName(String name){
        for (Reader reader: readers){
            if (reader instanceof MemberRecord){
                MemberRecord m = (MemberRecord) reader;
                if (m.getName().equalsIgnoreCase(name)){
                    return m;
                }
            }
        }
        return null;
    }

    @Override
    public void showBook() {
        for(Map.Entry<String, Book> entry: books.entrySet()){
            String key = entry.getKey();
            Book book = entry.getValue();

            System.out.println("Key: " + key + " Book: " + book);
        }
    }

    @Override
    public void removeBook(String id) {
        if (books.containsKey(id)){
            books.remove(id);
            System.out.println("kitap basariyla silindi");
        }else {
            System.out.println("bu id sahip kitap bulunamadi");
        }
    }

    @Override
    public void updateBook(String id, Book updatedBook) {
        if(books.containsKey(id)){
            books.put(id, updatedBook);
            System.out.println("kitap bilgileri guncellendi");
        }else{
            System.out.println("kitap bulunamadi");
        }
    }

    public void purchaseBook(String bookId, String readerName){
        if(!books.containsKey(bookId)){
            System.out.println("kitap bulunamadi");
            return;
        }

        Book book = books.get(bookId);

        if(!book.getStatus()){
            System.out.println("bu kitap zaten alinmis");
            return;
        }
        MemberRecord member = findMemberByName(readerName);
        if(member == null){
            System.out.println("'" + readerName + "' isimli üye bulunamadı");
            return;
        }


        book.setCurrentReader(readerName);
        books.remove(bookId);

        BillingService billingService = new BillingService();

        int bill = book.getPrice();
        System.out.println(readerName + " kitabi satin aldi. Fatura: " + bill);
    }

    @Override
    public void listBooksByCategory(String category) {
        for(Book b: books.values()){
            if(category.equalsIgnoreCase("study") && b instanceof StudyBooks){
                System.out.println("study books: " + b);
            } else if (category.equalsIgnoreCase("journal") && b instanceof JournalBooks) {
                System.out.println("journal books: " + b);
            }else if (category.equalsIgnoreCase("magazine") && b instanceof MagazineBooks) {
                System.out.println("magazine books: " + b);
            }else{
                System.out.println("boyle bir kategori yok");
            }
        }
    }

    public List<Book> searchByAuthor(String author){
        List<Book> matchedBooks = new ArrayList<>();

        for (Book b: books.values()){
            if(b.getAuthor().equalsIgnoreCase(author)){
                matchedBooks.add(b);
            }
        }

        if (matchedBooks.isEmpty()){
            System.out.println("Eslesen kitap bulunamadi");
        }else {
            System.out.println("yazar kitap: ");
            for (Book book: matchedBooks){
                System.out.println(book);
            }
        }
        return matchedBooks;
    }

    public Book searchById(String id){
        if(books.containsKey(id)){
            System.out.println("kitap: " + books.get(id));
            return books.get(id);
        }else{
            System.out.println("bu id kayitli kitap bulunmadi");
            return null;
        }
    }
    public Book searchByName(String name){
        for(Book b: books.values()){
            if(b.getName().equalsIgnoreCase(name)){
                System.out.println("Kitap: " + b);
                return b;
            }
        }
        System.out.println("Boyle bir kitap yok");
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) && Objects.equals(readers, library.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, readers);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
