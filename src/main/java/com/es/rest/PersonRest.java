package com.es.rest;

import com.es.dto.DtoPerson;
import com.es.servicio.ServicePerson;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Tag(name = "Person", description = "Person rest")
@RestController
@RequestMapping("/person")
public class PersonRest {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicePerson servicePerson;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoPerson.Response addPerson(@RequestBody DtoPerson.Post post) {
        return this.modelMapper.map(
                this.servicePerson.addPerson(post),
                DtoPerson.Response.class);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoPerson.Response updatePerson(
            @PathVariable Integer id,
            @RequestBody DtoPerson.Put put) {
        return this.modelMapper.map(
                this.servicePerson.updatePerson(id, put),
                DtoPerson.Response.class);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DtoPerson.Response> listPerson() {
        return this.servicePerson.listPerson()
                .stream()
                .map(customer -> this.modelMapper.map(
                customer,
                DtoPerson.Response.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DtoPerson.Response> findPerson(@RequestBody DtoPerson.Get get) {
        return this.servicePerson.findPerson(get)
                .stream()
                .map(customer -> this.modelMapper.map(
                customer,
                DtoPerson.Response.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoPerson.Response findPerson(@PathVariable Integer id) {

        return this.modelMapper.map(
                this.servicePerson.findPersonId(id),
                DtoPerson.Response.class);

    }
}
