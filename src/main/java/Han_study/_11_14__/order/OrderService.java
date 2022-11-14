package Han_study._11_14__.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
