package local.test.springboot.shopping.service;

import local.test.springboot.shopping.entity.UserAddress;

import java.util.List;

public interface AddressService {
    public void save(UserAddress userAddress);
    public List<UserAddress> findAllByUserId(int id);
}
