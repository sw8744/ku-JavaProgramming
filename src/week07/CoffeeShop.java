package week07;

public class CoffeeShop {
    private Coffee americano = new Coffee("아메리카노", 2000);
    private Coffee latte = new Coffee("카페라떼", 3000);
    private Coffee mocha = new Coffee("카페모카", 4000);

    interface Payment {
        void processPayment(double amount);
    }

    static class CashPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("현금결제 " + amount + "원 완료");
        }
    }

    static class CardPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("카드결제 " + amount + "원 완료");
        }
    }

    static class KakaoPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("카카오페이 결제 " + amount + "원 완료");
        }
    }

    public void orderCoffee(String name, double amount, Payment payment) {
        payment.processPayment(amount);
        switch (name) {
            case "아메리카노" -> americano.brew();
            case "카페라떼" -> latte.brew();
            case "카페모카" -> mocha.brew();
            default -> System.out.println("메뉴에 없음");
        }
    }

    static void main() {
        CoffeeShop greenjoa = new CoffeeShop();
        greenjoa.orderCoffee("아메리카노", 1000, new CashPayment());
        greenjoa.orderCoffee("카페모카", 2500, new CardPayment());
        greenjoa.orderCoffee("카페라떼", 2000, new KakaoPayment());
        greenjoa.orderCoffee("카페라떼", 2000, new Payment() {
            @Override
            public void processPayment(double amount) {
                System.out.println("계좌이체로 " + amount + "원 결제함");
            }
        });
    }

    private static class Coffee {
        String name;
        int brewTime;

        public Coffee(String name, int brewTime) {
            this.name = name;
            this.brewTime = brewTime;
        }

        public void brew() {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(name + " 제조 시작");
                        Thread.sleep(brewTime);
                        System.out.println(name + " 제조 완료");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            thread.start();
//
//            class CoffeeThread extends Thread {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(name + " 제조 시작");
//                        Thread.sleep(brewTime);
//                        System.out.println(name + " 제조 완료");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//
//            CoffeeThread coffeeThread = new CoffeeThread();
//            coffeeThread.start();
        }
    }
}
