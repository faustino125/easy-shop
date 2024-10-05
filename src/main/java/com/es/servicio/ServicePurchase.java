package com.es.servicio;

import com.es.dto.DtoPurchase;
import com.es.exception.ExceptionError;
import com.es.model.*;
import com.es.repository.RepositoryPurchase;
import jakarta.annotation.Resource;

import java.util.*;

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
@Service("servicePurchase")
public class ServicePurchase {

    @Resource
    private RepositoryPurchase repositoryPurchase;
    @Resource
    private ServiceProduct serviceProduct;
    @Resource
    private ServicePerson servicePerson;
    @Resource
    private ServiceUser serviceUser;

    public Purchase addPurchase(DtoPurchase.Post post) {
        Purchase purchase = new Purchase();
        Product product = this.serviceProduct.findProductId(post.getProduct_id());
        Person person = this.servicePerson.findPersonId(post.getCustomer_id());
        User user = this.serviceUser.findUser(post.getUser_id());
        purchase.setProduct_id(product);
        purchase.setPerson_id(person);
        purchase.setUnit_pre(post.getUnit_pre());
        purchase.setUser_id(user);
        purchase.setDate(new Date());

        this.repositoryPurchase.save(purchase);
        return purchase;
    }

    public Purchase updatePurchase(Integer id, DtoPurchase.Put put) {
        Purchase purchase = this.findPurchaseById(id);
        Product product = this.serviceProduct.findProductId(put.getProduct_id());
        Person person = this.servicePerson.findPersonId(put.getCustomer_id());
        User user = this.serviceUser.findUser(put.getUser_id());
        purchase.setProduct_id(product);
        purchase.setPerson_id(person);
        purchase.setUnit_pre(put.getUnit_pre());
        purchase.setUser_id(user);
        purchase.setDate(new Date());

        this.repositoryPurchase.save(purchase);
        return purchase;
    }

    public List<Purchase> listPurchase() {
        return this.repositoryPurchase.findAll();
    }

    public List<Purchase> findPurchase(DtoPurchase.Get get) {
        Purchase purchase = new Purchase();
        Product product = this.serviceProduct.findProductId(get.getProduct_id());
        Person person = this.servicePerson.findPersonId(get.getCustomer_id());
        User user = this.serviceUser.findUser(get.getUser_id());
        purchase.setProduct_id(product);
        purchase.setPerson_id(person);
        purchase.setUnit_pre(get.getUnit_pre());
        purchase.setUser_id(user);
        purchase.setDate(new Date());

        ExampleMatcher em = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase();

        return this.repositoryPurchase.findAll(Example.of(purchase, em));
    }

    public Purchase findPurchaseById(Integer id) {
        return this.repositoryPurchase.findById(id).orElseThrow(() -> {
            String description = String.format("Product with Id %d not found", id);
            return new ExceptionError(HttpStatus.NOT_FOUND, description);
        });
    }

}
