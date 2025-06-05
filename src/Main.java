import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        BillingService billingService = new BillingService();
        BookServices services = new BookServices(library.getBooks());
        Librarian librarian = new Librarian("kutuphaneci", "1234", billingService);

        Reader reader1 = new Reader("anil");
        Reader reader2 = new Reader("burak");

        Scanner scanner = new Scanner(System.in);

        library.newBook("STUDY-001", new StudyBooks(101, "Robert Lafore", "Data Structures in Java", 150, true, "2. Baskı", "2023-09-01", services, null));
        library.newBook("STUDY-002", new StudyBooks(102, "Al Sweigart", "Automate the Boring Stuff", 130, true, "1. Baskı", "2022-11-20", services, null));
        library.newBook("STUDY-003", new StudyBooks(103, "Stuart Russell", "AI: A Modern Approach", 220, true, "4. Baskı", "2024-05-10", services, null));

        library.newBook("MAG-001", new MagazineBooks(201, "National Geographic Society", "National Geographic - Haziran 2025", 50, true, "Haziran 2025", "2025-06-01", services, null));
        library.newBook("MAG-002", new MagazineBooks(202, "TIME USA", "TIME - Mayıs 2025", 40, true, "Mayıs 2025", "2025-05-01", services, null));
        library.newBook("MAG-003", new MagazineBooks(203, "Bonnier", "Popular Science - Nisan 2025", 45, true, "Nisan 2025", "2025-04-01", services, null));

        library.newBook("JOURNAL-001", new JournalBooks(301, "Dr. Emily Carter", "Software Engineering Methods", 80, true, "2025/1", "2025-01-15", services, null));
        library.newBook("JOURNAL-002", new JournalBooks(302, "Prof. Alan Turing", "Trends in Machine Learning", 95, true, "2025/2", "2025-02-10", services, null));
        library.newBook("JOURNAL-003", new JournalBooks(303, "Dr. Susan Lee", "CRISPR and Genetic Editing", 110, true, "2024/12", "2024-12-05", services, null));


        library.newBook("STUDY-004", new StudyBooks(104, "Robert Lafore", "Java Programming Patterns", 160, true, "1. Baskı", "2025-06-04", services, null));

        while (true) {
            System.out.println("\n--- KÜTÜPHANE OTOMASYON SİSTEMİ ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Ara (ID / İsim / Yazar)");
            System.out.println("3. Kitap Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kategoriye Göre Listele");
            System.out.println("6. Yazara Göre Listele");
            System.out.println("7. Kitap Ödünç Al");
            System.out.println("8. Kitap İade Et");
            System.out.println("9. Fatura Kes (Satın Alma)");
            System.out.println("10. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Book ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Price: ");
                    int price = scanner.nextInt(); scanner.nextLine();
                    Book book = new StudyBooks(id, author, title, price, true, "1. Baskı", "2025-01-01", services, null);
                    library.newBook("BOOK-" + id, book);
                    break;

                case 2:
                    System.out.print("Arama tipi (id/name/author): ");
                    String type = scanner.nextLine();
                    System.out.print("Aranacak değer: ");
                    String val = scanner.nextLine();
                    switch (type.toLowerCase()) {
                        case "id" -> services.searchById(val);
                        case "name" -> services.searchByName(val);
                        case "author" -> services.searchByAuthor(val);
                        default -> System.out.println("Geçersiz arama tipi.");
                    }
                    break;

                case 3:
                    System.out.print("Güncellenecek kitap ID: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Yeni başlık: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Yeni yazar: ");
                    String newAuthor = scanner.nextLine();

                    System.out.print("Yeni fiyat: ");
                    int newPrice = scanner.nextInt(); scanner.nextLine();

                    System.out.print("Kitap türü (study/journal/magazine): ");
                    String bookType = scanner.nextLine();

                    Book updatedBook;

                    switch (bookType.toLowerCase()) {
                        case "study" -> updatedBook = new StudyBooks(0, newAuthor, newTitle, newPrice, true, "Güncel Baskı", "2025-06-01", services, null);
                        case "journal" -> updatedBook = new JournalBooks(0, newAuthor, newTitle, newPrice, true, "Güncel Baskı", "2025-06-01", services, null);
                        case "magazine" -> updatedBook = new MagazineBooks(0, newAuthor, newTitle, newPrice, true, "Güncel Baskı", "2025-06-01", services, null);
                        default -> {
                            System.out.println("Geçersiz kitap türü.");
                            return;
                        }
                    }

                    librarian.updateBook(updateId, updatedBook);
                    break;

                case 4:
                    System.out.print("Silinecek kitap ID: ");
                    String removeId = scanner.nextLine();
                    librarian.removeBook(removeId);
                    break;

                case 5:
                    System.out.print("Kategori (study/journal/magazine): ");
                    String category = scanner.nextLine();
                    reader1.listBooksByCategory(category);
                    break;

                case 6:
                    System.out.print("Yazar adı: ");
                    String yazar = scanner.nextLine();
                    services.searchByAuthor(yazar);
                    break;

                case 7:
                    System.out.print("Kitap adı: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Okuyucu adı: ");
                    String readerName = scanner.nextLine();
                    if (readerName.equalsIgnoreCase("ahmet")) {
                        reader1.barrowBook(bookName, readerName);
                    } else {
                        reader2.barrowBook(bookName, readerName);
                    }
                    break;

                case 8:
                    System.out.print("İade edilecek kitap adı: ");
                    String returnBookName = scanner.nextLine();

                    System.out.print("Okuyucu adı: ");
                    String returnReaderName = scanner.nextLine();

                    if (returnReaderName.equalsIgnoreCase("anil")) {
                        reader1.returnBook(returnBookName, returnReaderName);
                    } else if (returnReaderName.equalsIgnoreCase("burak")) {
                        reader2.returnBook(returnBookName, returnReaderName);
                    } else {
                        System.out.println("Geçersiz kullanıcı.");
                    }
                    break;

                case 9:
                    System.out.print("Satın alınacak kitap ID: ");
                    String purchaseId = scanner.nextLine();
                    System.out.print("Okuyucu adı: ");
                    String buyer = scanner.nextLine();
                    if (buyer.equalsIgnoreCase("anil")) {
                        reader1.purchaseBook(purchaseId, buyer);
                    } else {
                        reader2.purchaseBook(purchaseId, buyer);
                    }
                    break;

                case 10:
                    System.out.println("Çıkılıyor...");
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}
