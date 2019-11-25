package com.ecommerce.ecommerceapi.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity Product
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @NotNull
    private String price;

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id")
    private ProductCategory categorie;

    private String userId;

    private String created;

}
