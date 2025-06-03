public class Librarian {
    private String name;
    private String password;
    private IBillCreator billCreator;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private void searchBook(){}
    private void verifyMember(){}
    private void issueBook(){}
    private void calculateFine(){}
    private void createBill(){}
    private void returnBook(){}
}
