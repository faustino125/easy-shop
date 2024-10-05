package com.es.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Setter
@Getter
@Entity
@Table(name = "person", schema = "es")
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer id_person;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "nit")
    private String nit;
    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog_id;

    @OneToMany(mappedBy = "person_id")
    private Set<Product> product;
    @OneToMany(mappedBy = "person_id")
    private Set<User> user;
    @OneToMany(mappedBy = "person_id")
    private Set<Purchase> purchase;

}
