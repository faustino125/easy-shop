package com.es.servicio;

import com.es.dto.DtoCatalog;
import com.es.exception.ExceptionError;
import com.es.model.Catalog;
import com.es.repository.RepositoryCatalog;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Service("serviceCatalog")
public class ServiceCatalog {
    @Resource
    private RepositoryCatalog repositoryCatalog;
    
    public Catalog findCatalogId(String id) {
    return this.repositoryCatalog.findById(id).orElseThrow(() -> {
        String description = String.format("Product with Id %d not found", id);
        return new ExceptionError(HttpStatus.NOT_FOUND, description);
    });
    }
    
    public List<Catalog> findCatalog(DtoCatalog.Get get){
        Catalog catalog = new Catalog();
        catalog.setId(get.getId());
        catalog.setName(get.getName());
        catalog.setDescription(get.getDescription());
        catalog.setType(get.getType());
        
        ExampleMatcher em = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase();
        return this.repositoryCatalog.findAll(
                Example.of(catalog, em));
        
    }

    
}
