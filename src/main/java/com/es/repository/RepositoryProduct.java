package com.es.repository;

import com.es.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Repository("repositoryProduct")
public interface RepositoryProduct extends JpaRepository<Product, Integer>{
    
}
