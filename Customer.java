package mission.Nike;

public class Customer {
    boolean isCustomerLikeDelivery; // 고객의 배송 주문 선호 여부
    private long cashAmount;
    private String feeling;

    Customer(long cashAmount, boolean isCustomerLikeDelivery) {
        this.cashAmount = cashAmount;
        this.isCustomerLikeDelivery = isCustomerLikeDelivery;
        this.feeling = "기분이 좋다";
    }

    public void askSneakers(Staff staff, NikeSneakers nikeSneakers) {
        System.out.println("손님 : Nike 운동화에 대해 알려주세요");
        staff.describeItem(nikeSneakers);
    }

    public boolean checkAvailablePay(long price) { //가격과 잔고를 비교해서
        if (price > cashAmount) //잔고가 부족하면
            return false;
        else return true; //잔고가 충분하면
    }

    public void payForSneakers(long price) {
        System.out.println("손님 : " + price + "원 결제 완료!");
        this.setCashAmount(price); //물건 가격 결제
    }

    public void wearSneakers(NikeSneakers nikeSneakers) { //물건을 받고 특징과 기분 묘사
        System.out.println("손님 : 이 운동화는 " + nikeSneakers.getNikeSneakersFeature() + " 특징이 있네요");
        System.out.println("손님 : 지금 기분은 " + this.feeling);
    }

    public long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(long price) {
        this.cashAmount -= price; //잔고에서 물건 가격만큼 빼기
    }

    public void visitLater() {
        System.out.println("손님 : 다음에 올게요");
    }

    public boolean isCustomerLikeDelivery() {
        return isCustomerLikeDelivery;
    }
}
