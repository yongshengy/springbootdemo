package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.Product;
import local.test.springboot.shopping.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {
    public List<ProductCategory> findProductCategoryByLevel(ProductCategory productCategory);
    public List<Product> findAllProductByLevel(ProductCategory productCategory);
}
