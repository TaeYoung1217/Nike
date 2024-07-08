package mission.Nike;

public class OrderSneakersSituation {
    public static void main(String[] args) {
        // 변수 변경 가능
        // Customer 의 잔액, DeliveryManager 매상, Staff 매상은 모두 10만원 시작 입니다.

        /**
         *  필수 인스턴스 생성
         *  Customer, staff, DeliveryManager를 생성하고 시작합니다.
         *  각각 Customer, Staff, DeliveryManager 는 정보 은닉화 를 따르기 때문에 한정된 정보를 가지게 됩니다.
         *
         *  Customer: 자신의 Cache 와 배송 주문선호 여부
         *  Staff: 자신의 매상, Nike 운동화 정보, 매장의 Nike 운동화 재고 보유여부
         *  DeliverManager: 자신의 매상, Nike 운동화 정보, 포장 정보
         * */


        // TODO: 클래스를 선언하고, 객체간의 협력으로 구현해주세요.


        NikeSneakers nikeSneakers = new NikeSneakers("편안한", 62_300, false); //신발객체 생성

        Customer customer = new Customer(100_000, true); //고객 객체 생성
        Staff staff = new Staff(100_000); //점원 객체 생성
        DeliveryManager deliveryManager = new DeliveryManager(100_000); //배송담당자 객체 생성

        customer.askSneakers(staff, nikeSneakers); //운동화 정보 물어봄
        if (customer.checkAvailablePay(nikeSneakers.getNikeSneakersPrice())) { //운동화의 가격 정보를 가져와 잔고와 비교, 잔고가 있으면
            System.out.println("손님 : 구매를 원합니다.");
            if (staff.checkHavingItem()) { //재고가 있으면
                staff.informPrice(customer); //가격을 알려주고 결제 진행
                staff.giveItemToCustomer(customer); //점원은 고객에게 결제한 물건 전달
            } else { //재고가 없으면
                System.out.println("점원 : 재고가 없습니다. 배송을 해드릴까요?");
                if (customer.isCustomerLikeDelivery()) { //배송을 선호하면
                    System.out.println("손님 : 네 배송을 해주세요.");
                    staff.informPrice(customer); //가격을 알려주고 배송비 결제 진행
                    staff.askForDeliver(deliveryManager, nikeSneakers); //배송 담당자에게 배송 정보 전달
                    if (staff.informDeliver(customer, deliveryManager)) { //결제 성공하면
                        deliveryManager.makePackage(nikeSneakers);
                        deliveryManager.giveItemToCustomer(customer); //배송담당자가 손님에게 물건 전달
                    } else { //잔액 부족으로 결제 실패하면
                        System.out.println("손님 : 환불해주세요");
                        staff.refund(customer, nikeSneakers); //환불 진행
                        customer.visitLater(); //다음에 올게요
                    }
                } else { //배송을 원하지 않으면
                    customer.visitLater(); //다음에 올게요
                }
            }
        } else { //잔고가 부족하면
            customer.visitLater(); //다음에 올게요
        }

        //변수 정보 확인용
        System.out.println("\n점원 매출 : " + staff.getSalesAmount());
        System.out.println("배송 매출 : " + deliveryManager.getSalesAmount());
        System.out.println("고객 잔액 : " + customer.getCashAmount());
    }
}
