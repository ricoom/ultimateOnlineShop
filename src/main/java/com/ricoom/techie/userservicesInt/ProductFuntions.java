package com.ricoom.techie.userservicesInt;

import java.util.List;

import com.ricoom.techie.models.Product;

public interface ProductFuntions {
    public Product addNewProduct(Product product);
    public List<Product> getAllProducts();
    public void removeProduct(String productname);
    public void updateProduct(String productname);
    public void addTocart(String username,String productName);
    public Product removeFromCart(String username,String productName);
    public List<Product> getAllInCart(String username);
}
