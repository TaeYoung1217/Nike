package mission.Nike;

public class Staff implements giveToCustomer {
    private long salesAmount;
    private int daysForDeliver;
    private int costForDeliver;
    private NikeSneakers nikeSneakers;

    Staff(long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void describeItem(NikeSneakers nikeSneakers) {
        System.out.println("점원 : 이 운동화의 특징은 " + nikeSneakers.getNikeSneakersFeature()
                + "이고 가격은 " + nikeSneakers.getNikeSneakersPrice() + "원 입니다");
        this.nikeSneakers = nikeSneakers;
    }

    public boolean checkHavingItem() { //재고 여부 확인
        return nikeSneakers.isHavingNikeSneakersInStore();
    }

    public void giveItemToCustomer(Customer customer) {
        customer.wearSneakers(nikeSneakers); //손님에게 물건 전달
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(long salesAmount) {
        this.salesAmount += salesAmount;
    }

    public void informPrice(Customer customer) {
        long price = nikeSneakers.getNikeSneakersPrice();
        System.out.println("점원 : 운동화 가격은 " + price + "입니다. 결제 부탁드립니다.");
        customer.payForSneakers(price); //결제 진행
        setSalesAmount(price); //점원의 매출에 물건 가격 추가
    }

    public void askForDeliver(DeliveryManager deliveryManager, NikeSneakers nikeSneakers) {
        deliveryManager.setNikeSneakers(nikeSneakers); //배송담당자에게 물건 정보 전달
        this.daysForDeliver = deliveryManager.getDaysForDeliver(); //배송 일정 전달받아 저장
        this.costForDeliver = deliveryManager.getCostForDeliver(); //배송비 전달 받아 저장
    }

    public boolean informDeliver(Customer customer, DeliveryManager deliveryManager) {
        System.out.println("점원 : 예상 배송 일정은 " + this.daysForDeliver + "일 이고, 배송료는 " + this.costForDeliver + "원 입니다.");
        if (customer.checkAvailablePay(this.costForDeliver)) { //배송비 결제 가능한지 확인, 결제되면
            customer.payForSneakers(this.costForDeliver); //결제 진행
            deliveryManager.setSalesAmount(this.costForDeliver); //배송담당자 매출 증가
            return true;
        } else return false; //배송비 결제할 잔액 부족하면
    }

    public void refund(Customer customer, NikeSneakers nikeSneakers) {
        System.out.println("점원 : 환불 완료되었습니다");
        customer.setCashAmount(-nikeSneakers.getNikeSneakersPrice());
        this.salesAmount -= nikeSneakers.getNikeSneakersPrice();
    }
}
