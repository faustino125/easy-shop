package com.es.servicio;

import com.es.dto.DtoUser;
import com.es.exception.ExceptionError;
import com.es.model.*;
import jakarta.annotation.Resource;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.es.repository.RepositoryUser;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Service("serviceUser")
public class ServiceUser {

    @Resource
    private RepositoryUser repositoryUser;
    @Resource
    private ServiceCatalog serviceCatalog;
    @Resource
    private ServicePerson servicePerson;

    public User addUser(DtoUser.Post post) {
        User user = new User();
        Person person = this.servicePerson.findPersonId(post.getPerson_id());
        Catalog catalog = this.serviceCatalog.findCatalogId(post.getRol_id());
        user.setUser(post.getUser());
        user.setPass(post.getPass());
        user.setPerson_id(person);
        user.setCatalog_id(catalog);
        user.setStatus(true);
        this.repositoryUser.save(user);

        return user;
    }

    public User upUser(Integer id, DtoUser.Put put) {
        User user = this.findpersonId(id);
        Person person = this.servicePerson.findPersonId(put.getPerson_id());
        Catalog catalog = this.serviceCatalog.findCatalogId(put.getRol_id());
        user.setUser(put.getUser());
        user.setPass(put.getPass());
        user.setPerson_id(person);
        user.setCatalog_id(catalog);
        user.setStatus(put.getStatus());
        this.repositoryUser.save(user);

        return user;
    }

    public List<User> userAll() {
        return this.repositoryUser.findAll();
    }

    public List<User> findUserAll(DtoUser.Get get) {
        User user = new User();
        Person person = this.servicePerson.findPersonId(get.getPerson_id());
        Catalog catalog = this.serviceCatalog.findCatalogId(get.getRol_id());
        user.setUser(get.getUser());
        user.setPass(get.getPass());
        user.setPerson_id(person);
        user.setCatalog_id(catalog);
        user.setStatus(get.getStatus());

        ExampleMatcher em = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase();

        return this.repositoryUser.findAll(Example.of(user, em));
    }

    public User findUser(Integer id) {
        return this.findpersonId(id);
    }

    private User findpersonId(Integer id) {
        return this.repositoryUser.findById(id).orElseThrow(() -> {
            String description = String.format("User with Id %d not found", id);
            return new ExceptionError(HttpStatus.NOT_FOUND, description);
        });
    }

}
