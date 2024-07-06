package mission.Nike;

public class DeliveryManager implements giveToCustomer {
    private int daysForDeliver = 3;
    private int costForDeliver = 15_000;
    private long salesAmount;
    private NikeSneakers nikeSneakers;

    DeliveryManager(long salesAmount) {
        this.salesAmount = salesAmount;
    }


    public int getDaysForDeliver() {
        return daysForDeliver;
    }

    public int getCostForDeliver() {
        return costForDeliver;
    }

    public void setNikeSneakers(NikeSneakers nikeSneakers) {
        this.nikeSneakers = nikeSneakers;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(long salesAmount) {
        this.salesAmount += salesAmount;
    }

    @Override
    public void giveItemToCustomer(Customer customer) {
        System.out.println("배송담당자 : 배송이 완료되었습니다.");
        customer.wearSneakers(nikeSneakers);
    }

    public void makePackage(NikeSneakers nikeSneakers) {
        System.out.println("배송담당자 : 택배 패키지를 만듭니다.");
        boolean wrapping = true;
        nikeSneakers.setWrapped(wrapping);
        System.out.println("배송담당자 : 포장 완료!");

        System.out.println("배송담당자 : 배송을 시작합니다.");
    }
}
