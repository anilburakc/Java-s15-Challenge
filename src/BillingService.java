public class BillingService implements IBillCreator, IBillPayer{
    @Override
    public int calculateFine(int gecikenGun) {
        return 10 * gecikenGun;
    }

    @Override
    public int createBill(int gecikenGun) {
        return calculateFine(gecikenGun)+ 30;
    }

    @Override
    public void payBill() {

    }


}
