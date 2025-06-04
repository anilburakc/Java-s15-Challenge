import java.util.Objects;

public class Librarian {
    private String name;
    private String password;
    private IBillCreator billCreator;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Librarian(String name, String password, IBillCreator billCreator) {
        this.name = name;
        this.password = password;
        this.billCreator = billCreator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IBillCreator getBillCreator() {
        return billCreator;
    }

    public void setBillCreator(IBillCreator billCreator) {
        this.billCreator = billCreator;
    }

    private void searchBook(){}
    private void verifyMember(){}
    private void issueBook(){}
    private void calculateFine(){}
    private void createBill(){}
    private void returnBook(){}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(name, librarian.name) && Objects.equals(password, librarian.password) && Objects.equals(billCreator, librarian.billCreator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, billCreator);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", billCreator=" + billCreator +
                '}';
    }
}
