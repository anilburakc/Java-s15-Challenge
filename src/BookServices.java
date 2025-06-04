import java.util.List;
import java.util.Map;

public class BookServices {
    private Map<String, Book> books;
    private List<Reader> readers;

    public String getTitle(Book book){
        return book.getName();
    }

    public String getAuthor(Book book) {
        return book.getAuthor();
    }

    public String getOwner(Book book){
        return book.getCurrentReader();
    }
    public void changeOwner(Book book, String newReader){
        if(book.getCurrentReader().equals(null) || !book.getCurrentReader().contains(newReader)){
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
}
