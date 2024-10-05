package com.es.rest;

import com.es.dto.DtoUser;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import com.es.servicio.ServiceUser;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Tag(name = "User", description = "User rest")
@RestController
@RequestMapping("/user")
public class UserRest {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServiceUser serviceUser;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoUser.Response addUser(@RequestBody DtoUser.Post post) {
        return this.modelMapper.map(
                this.serviceUser.addUser(post),
                DtoUser.Response.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoUser.Response updateUser(
            @PathVariable Integer id,
            @RequestBody DtoUser.Put put) {
        return this.modelMapper.map(
                this.serviceUser.upUser(id, put),
                DtoUser.Response.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DtoUser.Response> userAll() {
        return this.serviceUser
                .userAll()
                .stream()
                .map(user -> this.modelMapper.map(
                user,
                DtoUser.Response.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoUser.Response findUser(@PathVariable Integer id){
        return this.modelMapper.map(
                this.serviceUser.findUser(id),
                DtoUser.Response.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DtoUser.Response> findUser(@RequestBody DtoUser.Get get) {
        return this.serviceUser.findUserAll(get)
                .stream()
                .map(user -> this.modelMapper.map(
                user,
                DtoUser.Response.class))
                .collect(Collectors.toList());
    }

}
