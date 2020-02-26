package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.Cart;

import java.util.List;

public interface CartRepository {
    public void save(Cart cart);
    public List<Cart> findAllByUserId(int id);
    public void deleteById(int id);
    public void update(Cart cart);
    public void clearCartByUserId(int userId);
}
