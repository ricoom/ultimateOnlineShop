package com.ricoom.techie.services;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ricoom.techie.models.Product;
import com.ricoom.techie.models.User;
import com.ricoom.techie.repositories.ProductRepository;
import com.ricoom.techie.repositories.UserRepository;
import com.ricoom.techie.userservicesInt.ProductFuntions;

import lombok.AllArgsConstructor;
@Transactional
@Service
@AllArgsConstructor
public class ProductService implements ProductFuntions {
    private ProductRepository productrepository;
    private UserRepository userRepository;

    
    
    @Override
    public Product addNewProduct(Product product) {
        
        return productrepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productrepository.findAll();
    }

    @Override
    public void removeProduct(String productname) {
        Product product=productrepository.findProductByproductName(productname);
        productrepository.delete(product);
    }

    @Override
    public void updateProduct(String productname) {
        Product product=productrepository.findProductByproductName(productname);
        productrepository.saveAndFlush(product);
        
    }

    @Override
    public void addTocart(String username,String productName) {
        User user=userRepository.findUserByusername(username);
        Product product=productrepository.findProductByproductName(productName);
        if(user.getProducts().contains(product)){
            throw new RuntimeException("product already added to cart");
        }else{
             user.setProducts(Arrays.asList(product));
        System.out.println("{} added ");

        }
       


    }

    @Override
    public Product removeFromCart(String username, String productName) {
        Product product=productrepository.findProductByproductName(productName);
        User user=userRepository.findUserByusername(username);

        user.getProducts().remove(product);


        
        return product;
    }

    @Override
    public List<Product> getAllInCart(String username) {
        User user=userRepository.findUserByusername(username);
       
        return  user.getProducts();
    }



    
}
