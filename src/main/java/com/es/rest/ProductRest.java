package com.es.rest;

import com.es.servicio.ServiceProduct;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.es.dto.DtoProduct;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Tag(name = "Product", description = "Product rest")
@RestController
@RequestMapping("/product")
public class ProductRest {

    @Resource
    private ModelMapper modelMapper;

    @Resource
    private ServiceProduct serviceProduct;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoProduct.Response addProducdt(@RequestBody DtoProduct.Post post) {
        return this.modelMapper.map(
                this.serviceProduct.addProduct(post),
                DtoProduct.Response.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoProduct.Response updateProduct(
            @PathVariable Integer id,
            @RequestBody DtoProduct.Put put) {
        return this.modelMapper.map(
                this.serviceProduct.updateProduct(id, put),
                DtoProduct.Response.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DtoProduct.Response> productAll() {
        return this.serviceProduct.listProduct()
                .stream()
                .map(product -> this.modelMapper.map(
                product,
                DtoProduct.Response.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DtoProduct.Response> findProductAll(@RequestBody DtoProduct.Get get) {
        return this.serviceProduct.findProduct(get)
                .stream()
                .map(product -> this.modelMapper.map(
                product,
                DtoProduct.Response.class))
                .collect(Collectors.toList());

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoProduct.Response findProduct(@PathVariable Integer id) {
        return this.modelMapper.map(
                this.serviceProduct.findProductId(id),
                DtoProduct.Response.class);
    }

}
