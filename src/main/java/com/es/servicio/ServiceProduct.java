package com.es.servicio;

import com.es.dto.DtoProduct;
import com.es.exception.ExceptionError;
import com.es.model.*;
import com.es.repository.RepositoryProduct;
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
@Service("serviceProduct")
public class ServiceProduct {

    @Resource
    private RepositoryProduct repositoryProduct;

    @Resource
    private ServicePerson servicePerson;

    @Resource
    private ServiceCatalog serviceCatalog;

    public Product addProduct(DtoProduct.Post post) {
        Product product = new Product();
        Catalog catalog = this.serviceCatalog.findCatalogId(post.getCategory_id());
        Person person = this.servicePerson.findPersonId(post.getSupplier_id());
        product.setName(post.getName());
        product.setDescription(post.getDescription());
        product.setPrice(post.getPrice());
        product.setStock(post.getStock());
        product.setDue_date(post.getDue_date());
        product.setImage(post.getImage());
        product.setCatalog_id(catalog);
        product.setPerson_id(person);
        this.repositoryProduct.save(product);
        return product;
    }

    public Product updateProduct(Integer id, DtoProduct.Put put) {
        Product product = this.findProductById(id);
        Catalog catalog = this.serviceCatalog.findCatalogId(put.getCategory_id());
        Person person = this.servicePerson.findPersonId(put.getSupplier_id());
        product.setName(put.getName());
        product.setDescription(put.getDescription());
        product.setPrice(put.getPrice());
        product.setStock(put.getStock());
        product.setDue_date(put.getDue_date());
        product.setImage(put.getImage());
        product.setCatalog_id(catalog);
        product.setPerson_id(person);
        this.repositoryProduct.save(product);
        return product;
    }

    public List<Product> listProduct() {
        return this.repositoryProduct.findAll();
    }

    public List<Product> findProduct(DtoProduct.Get get) {
        Product product = new Product();
        Catalog catalog = this.serviceCatalog.findCatalogId(get.getCategory_id());
        Person person = this.servicePerson.findPersonId(get.getSupplier_id());
        product.setName(get.getName());
        product.setDescription(get.getDescription());
        product.setPrice(get.getPrice());
        product.setStock(get.getStock());
        product.setDue_date(get.getDue_date());
        product.setImage(get.getImage());
        product.setCatalog_id(catalog);
        product.setPerson_id(person);

        ExampleMatcher em = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase();
        return this.repositoryProduct.findAll(
                Example.of(product, em));
    }

    public Product findProductId(Integer id) {
        return this.findProductById(id);
    }

    private Product findProductById(Integer id) {
        return this.repositoryProduct.findById(id).orElseThrow(() -> {
            String description = String.format("Product with Id %d not found", id);
            return new ExceptionError(HttpStatus.NOT_FOUND, description);
        });
    }
}
