package com.ecommerce.ecommerceapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Entity Product
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_groups")
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long idCategorie;

    @NotNull
    private String nomCategorie;

    private String description;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Collection<Product> produits=new ArrayList<Product>();

    @Builder
    public ProductCategory(
                       String nomCategorie,
                       String description) {

        this.nomCategorie = nomCategorie;
        this.description = description;
    }

}
