package local.test.springboot.shopping.service;

import local.test.springboot.shopping.entity.Product;
import local.test.springboot.shopping.entity.ProductCategory;

import java.util.List;

public interface ProductService {
    public List<ProductCategory> findAllProductCategory();
    public List<Product> findAllProductByLevel(ProductCategory productCategory);
    public Product findById(int id);
    public List<Product> findAllByKeyWord(String keyWord);
}
