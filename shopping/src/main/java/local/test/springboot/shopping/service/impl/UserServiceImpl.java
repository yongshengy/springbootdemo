package local.test.springboot.shopping.service.impl;

import local.test.springboot.shopping.entity.User;
import local.test.springboot.shopping.entity.UserAddress;
import local.test.springboot.shopping.repository.UserRepository;
import local.test.springboot.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String loginName, String passWord) {
        if(loginName == null) {
            return null;
        }
        return userRepository.login(loginName, passWord);
    }

    @Override
    public List<UserAddress> findAllAddressByUserId(int id) {
        return userRepository.findAllAddressByUserId(id);
    }

    @Override
    public void register(User user) {
        userRepository.register(user);
    }
}
