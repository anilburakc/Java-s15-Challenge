public class MemberRecord {
    private String memberId;
    private Type type;
    private String dateOfMembership;
    private int noBooksIssued;
    private Long maxBookLimit;
    private String name;
    private String address;
    private Integer phoneNo;
    private IBillPayer billPayer;

    public MemberRecord(String memberId, Type type, String dateOfMembership, int noBooksIssued, Long maxBookLimit, String name, String address, Integer phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = noBooksIssued;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    private void getMember(){}
    private void incBookIssued(){}
    private void decBookIssued(){}
    private void payBill(){}
}
