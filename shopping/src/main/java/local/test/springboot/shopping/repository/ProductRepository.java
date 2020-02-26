package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.Product;

import java.util.List;

public interface ProductRepository {
    public Product findById(int id);
    public List<Product> findAllByKeyWord(String keyWord);
}
