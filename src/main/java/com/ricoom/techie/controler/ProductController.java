package com.ricoom.techie.controler;


import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ricoom.techie.models.Product;
import com.ricoom.techie.services.ProductService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
@Slf4j
@Controller
@AllArgsConstructor
public class ProductController {
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


    @GetMapping("/addProduct")
    public String getProductForm(Product product){

        return "productForm";
    }
    @PostMapping("/saveProduct")
    public String addNewProduct( @Valid Product product,BindingResult result,Model model){
        if(result.hasErrors()){
            return "productForm";
        }

       productservice.addNewProduct(product);

        return "productForm";
    }

    

}
