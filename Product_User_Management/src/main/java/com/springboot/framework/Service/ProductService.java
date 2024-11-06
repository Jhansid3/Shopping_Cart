package com.springboot.framework.Service;

import com.springboot.framework.Entity.Product;
import com.springboot.framework.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

public List<Product> getAllProducts(){
    return productRepository.findAll();
}
 public Product getProductById(Integer product_id){
    Optional<Product> optionalProduct = productRepository.findById(product_id);
    if(optionalProduct.isPresent())
    {
        return optionalProduct.get();
    }
    else{
        return null;
    }

 }
public Product createproduct(Product product){
    return productRepository.save(product);
}

public Product updateproduct(Integer product_id,Product product){
    Optional<Product> productOptional= productRepository.findById(product_id);
    if (productOptional.isPresent()) {
        Product productDetails = productOptional.get();
        productDetails.setName(product.getName());
        productDetails.setDescription(product.getDescription());
        productDetails.setPrice(product.getPrice());
        productDetails.setCategory(product.getCategory());
        productDetails.setImageUrl(product.getImageUrl());
        productDetails.setPopularity(product.getPopularity());
        return productRepository.save(productDetails);
    }
    else {
        return null;
    }
}
public void productDeletedById(int product_id){
     productRepository.deleteById(product_id);
}


}
