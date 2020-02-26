package local.test.springboot.shopping.service;

import local.test.springboot.shopping.entity.Order;
import local.test.springboot.shopping.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    public Order addOrder(int userId, String userAddress, int cost);
    public List<OrderDetail> findByOrderId(int orderId);
    public List<Order> findByUserId(int userId);
}
