package com.es.servicio;

import com.es.dto.DtoPerson;
import com.es.exception.ExceptionError;
import com.es.model.Person;
import com.es.model.Catalog;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import com.es.repository.RepositoryPerson;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Service("servicePerson")
public class ServicePerson {

    @Resource
    private RepositoryPerson repositoryPerson;

    @Resource
    private ServiceCatalog serviceCatalog;

    public Person addPerson(DtoPerson.Post post) {
        Person person = new Person();
        Catalog catalog= this.serviceCatalog.findCatalogId(post.getType_id());
        person.setName(post.getName());
        person.setAddress(post.getAddress());
        person.setPhone(post.getPhone());
        person.setNit(post.getNit());
        person.setEmail(post.getEmail());
        person.setCatalog_id(catalog);
        this.repositoryPerson.save(person);
        return person;
    }

    public Person updatePerson(Integer id, DtoPerson.Put put) {
        Person person = this.findPersonId(id);
        Catalog rol= this.serviceCatalog.findCatalogId(put.getType_id());
        person.setName(put.getName());
        person.setAddress(put.getAddress());
        person.setPhone(put.getPhone());
        person.setNit(put.getNit());
        person.setEmail(put.getEmail());
        person.setCatalog_id(rol);
        this.repositoryPerson.save(person);
        return person;
    }

    public List<Person> listPerson() {
        return this.repositoryPerson.findAll();
    }

    public List<Person> findPerson(DtoPerson.Get get) {
        Person person = new Person();
        Catalog catalog= this.serviceCatalog.findCatalogId(get.getType_id());
        person.setName(get.getName());
        person.setAddress(get.getAddress());
        person.setPhone(get.getPhone());
        person.setNit(get.getNit());
        person.setEmail(get.getEmail());
        person.setCatalog_id(catalog);
        ExampleMatcher em = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase();
        return this.repositoryPerson.findAll(
                Example.of(person,em));
    }

    public Person findPersonId(Integer id) {
        return this.repositoryPerson.findById(id).orElseThrow(() -> {
            String description = String.format("Product with Id %d not found", id);
            return new ExceptionError(HttpStatus.NOT_FOUND, description);
        });
    }
}
