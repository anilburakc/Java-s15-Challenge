import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MemberRecord extends Reader {
    private List<MemberRecord> members;
    private String memberId;
    private Type type;
    private String dateOfMembership;
    private int noBooksIssued;
    private static long maxBookLimit = 5;
    private String name;
    private String address;
    private Integer phoneNo;
    private IBillPayer billPayer;

    public MemberRecord(String name, List<MemberRecord> members, String memberId, Type type, String dateOfMembership, int noBooksIssued, String name1, String address, Integer phoneNo, IBillPayer billPayer) {
        super(name);
        this.members = members;
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = noBooksIssued;
        this.name = name1;
        this.address = address;
        this.phoneNo = phoneNo;
        this.billPayer = billPayer;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public Long getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(Long maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public IBillPayer getBillPayer() {
        return billPayer;
    }

    public void setBillPayer(IBillPayer billPayer) {
        this.billPayer = billPayer;
    }

    public void getMember(){
        System.out.println(members.toString());
    }
    public void incBookIssued(String memberId){
//        for (MemberRecord m: members){
//            if(m.getMemberId().equals(memberId)){
//                if (m.getNoBooksIssued()>=maxBookLimit){
//                    System.out.println("5'ten fazla kitap alamazsiniz");
//                }else {
//                    m.setNoBooksIssued(m.getNoBooksIssued() + 1);
//                }
//            }else{
//                System.out.println("boyle bir uye yok");
//            }
//        }

        if(this.noBooksIssued >= maxBookLimit){
            System.out.println("Maksimum kitap limitine ulaştınız (5 kitap)");
        } else {
            this.noBooksIssued++;
        }
    }
    public void decBookIssued(String memberId){
//        for (MemberRecord m: members){
//            if(m.getMemberId().equals(memberId)){
//                m.setNoBooksIssued(m.getNoBooksIssued() - 1);
//            }else{
//                System.out.println("boyle bir uye yok");
//            }
//        }
        if(this.noBooksIssued > 0){
            this.noBooksIssued--;
        }
    }
    public void payBill(){}

    public boolean hasReachedLimit(){
        return noBooksIssued>=maxBookLimit;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberRecord that = (MemberRecord) o;
        return noBooksIssued == that.noBooksIssued && Objects.equals(memberId, that.memberId) && type == that.type && Objects.equals(dateOfMembership, that.dateOfMembership) && Objects.equals(maxBookLimit, that.maxBookLimit) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phoneNo, that.phoneNo) && Objects.equals(billPayer, that.billPayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, type, dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo, billPayer);
    }


    @Override
    public String toString() {
        return "MemberRecord{" +
                "memberId='" + memberId + '\'' +
                ", type=" + type +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                ", noBooksIssued=" + noBooksIssued +
                ", maxBookLimit=" + maxBookLimit +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                ", billPayer=" + billPayer +
                '}';
    }
}
