package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.User;
import local.test.springboot.shopping.entity.UserAddress;

import java.util.List;

public interface UserRepository {
    public User login(String loginName, String passWord);
    public List<UserAddress> findAllAddressByUserId(int id);
    public void register(User user);
}
