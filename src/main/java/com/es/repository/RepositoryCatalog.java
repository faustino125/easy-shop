package com.es.repository;

import com.es.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Repository("repositoryCatalog")
public interface RepositoryCatalog extends JpaRepository<Catalog, String> {
    
}
