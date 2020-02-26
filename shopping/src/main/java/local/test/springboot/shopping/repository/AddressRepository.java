package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.UserAddress;

import java.util.List;

public interface AddressRepository {
    public void save(UserAddress userAddress);
    public List<UserAddress> findAllByUserId(int id);
}
