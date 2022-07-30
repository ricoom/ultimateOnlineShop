package com.ricoom.techie.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        @NotNull
    private String productName;
        @NotNull
    private String productDescription;
        @NotNull
    private String productCost;
    @NotNull
    @Column(length = 65555)
    private String imgurl;
    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<User> users;

}
