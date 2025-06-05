import java.util.*;

public class Library implements LibraryOperations{
    private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();
    private static Library instance = new Library();
    private Library(){
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
