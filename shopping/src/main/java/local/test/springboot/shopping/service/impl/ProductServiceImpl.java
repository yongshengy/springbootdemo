package local.test.springboot.shopping.service.impl;

import local.test.springboot.shopping.entity.Product;
import local.test.springboot.shopping.entity.ProductCategory;
import local.test.springboot.shopping.repository.ProductCategoryRepository;
import local.test.springboot.shopping.repository.ProductRepository;
import local.test.springboot.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductCategory> findAllProductCategory() {
        List<ProductCategory> list1 = productCategoryRepository.findProductCategoryByLevel(new ProductCategory(1,0));
        for(ProductCategory productCategory:list1){
            List<ProductCategory> list2 = productCategoryRepository.findProductCategoryByLevel(new ProductCategory(2,productCategory.getId()));
            for(ProductCategory productCategory2:list2){
                List<ProductCategory> list3 = productCategoryRepository.findProductCategoryByLevel(new ProductCategory(3,productCategory2.getId()));
                productCategory2.setProductCategories(list3);
            }
            productCategory.setProductCategories(list2);
        }
        //给一级分类添加对应的商品信息
        for (ProductCategory productCategory:list1){
            List<Product> products = productCategoryRepository.findAllProductByLevel(productCategory);
            productCategory.setLevelOneProducts(products);
        }
        return list1;
    }

    @Override
    public List<Product> findAllProductByLevel(ProductCategory productCategory) {
        return productCategoryRepository.findAllProductByLevel(productCategory);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByKeyWord(String keyWord) {
        return productRepository.findAllByKeyWord(keyWord);
    }

}
