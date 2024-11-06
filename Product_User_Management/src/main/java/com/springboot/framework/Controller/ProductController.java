package com.springboot.framework.Controller;

import com.springboot.framework.Entity.Product;
import com.springboot.framework.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {

   @Autowired
   private ProductService productService;

   @GetMapping
   public List<Product> getAllProducts() {
      return productService.getAllProducts();
   }
   @GetMapping ("/{id}")
   public Product getProductById(@PathVariable ("id") Integer product_id){
      return productService.getProductById(product_id);
   }

   @PostMapping()
   public Product createproduct(@RequestBody Product product) {
      return productService.createproduct(product);
   }

   @PutMapping("/{id}")
   public Product updateproduct(@PathVariable ("id") Integer product_id,@RequestBody Product product){
      return productService.createproduct(product);
   }

   @DeleteMapping("/{id}")
   public void productDeletedById(@PathVariable ("id") int product_id){
      productService.productDeletedById(product_id);


      }
   }

