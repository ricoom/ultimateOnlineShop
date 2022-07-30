package com.ricoom.techie.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricoom.techie.models.Product;
import com.ricoom.techie.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductRestController {
 private ProductService productservice;
   

  public String getUsername()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

if (principal instanceof UserDetails) {
return ((UserDetails)principal).getUsername();
} else {
return principal.toString();
}
    }


    @PostMapping("/addTocart/{productname}")
    public ResponseEntity<Product> addProductsTocart(@PathVariable String productname){
        try {
             productservice.addTocart(getUsername(), productname);
       System.out.println("added tocart");
            
        } catch (Exception e) {
            System.out.println(e);
        }
     
      return new ResponseEntity<>(HttpStatus.OK);
    }

}
