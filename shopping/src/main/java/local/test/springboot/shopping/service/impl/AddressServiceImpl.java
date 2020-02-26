package local.test.springboot.shopping.service.impl;

import local.test.springboot.shopping.entity.UserAddress;
import local.test.springboot.shopping.repository.AddressRepository;
import local.test.springboot.shopping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void save(UserAddress userAddress) {
        addressRepository.save(userAddress);
    }

    @Override
    public List<UserAddress> findAllByUserId(int id) {
        return addressRepository.findAllByUserId(id);
    }
}
