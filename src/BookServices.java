import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServices {
    private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();

//    public String getTitle(Book book){
//        return book.getName();
//    }
//
//    public String getAuthor(Book book) {
//        return book.getAuthor();
//    }
//
//    public String getOwner(Book book){
//        return book.getCurrentReader();
//    }


    public BookServices(Map<String, Book> books) {
        this.books = books;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public void changeOwner(Book book, String newReader){
        if(book.getCurrentReader() == null || !book.getCurrentReader().contains(newReader)){
            book.setCurrentReader(newReader);
            book.setStatus(false);
            System.out.println("islem basariyla gerceklesti");
        }else{
            System.out.println("hatali islem");
        }
    }
    public void display(){
        for(Map.Entry<String, Book> entry: books.entrySet()){
            String key = entry.getKey();
            Book book = entry.getValue();

            System.out.println("Key: " + key + " Book: " + book);
        }

    }
    public void updateStatus(Book book, boolean isAvaiable){
        for(Book b: books.values()){
            if(b.getName().contains(book.getName())){
                b.setStatus(isAvaiable);
                System.out.println("status degistirildi");
            }else {
                System.out.println("boyle bir kitap bulunamadi");
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
}
