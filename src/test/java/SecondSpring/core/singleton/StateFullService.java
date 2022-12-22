package SecondSpring.core.singleton;

public class StateFullService {

    private int price; // 상태를 유지하는 필드 10000 -> 20000

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
