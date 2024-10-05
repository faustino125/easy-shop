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
@Table(name="user", schema = "es")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;
    @Column(name = "user")
    private String user;
    @Column(name = "pass")
    private String pass;
    @Column(name = "status")
    private Boolean status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog_id;
    
    @OneToMany(mappedBy = "user_id")
    private Set<Purchase> purchase;
}
