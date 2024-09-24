package com.category.product.crud.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import com.category.product.crud.entity.Product;
import com.category.product.crud.entity.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page, 10));
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(productDetails.getName());
            return productRepository.save(product);
        }
        return null;
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
