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
@Table(name = "catalog", schema = "es")
public class Catalog implements Serializable{

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "catalog_id")
    private Set<Person> person;
    @OneToMany(mappedBy = "catalog_id")
    private Set<Product> product;
    @OneToMany(mappedBy = "catalog_id")
    private Set<User> user;

}
