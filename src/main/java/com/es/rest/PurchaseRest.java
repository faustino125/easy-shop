package com.es.rest;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.es.dto.DtoPurchase;
import com.es.model.Purchase;
import com.es.servicio.ServicePurchase;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Tag(name = "Purchase", description = "Purchase rest")
@RestController
@RequestMapping("/purchase")
public class PurchaseRest {

    @Resource
    private ModelMapper modelMapper;

    @Resource
    private ServicePurchase servicePurchase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoPurchase.Response add(@RequestBody DtoPurchase.Post post) {
        Purchase purchase = this.servicePurchase.addPurchase(post);
        return this.modelMapper.map(
                purchase,
                DtoPurchase.Response.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoPurchase.Response update(
            @PathVariable Integer id,
            @RequestBody DtoPurchase.Put put) {
        Purchase purchase = this.servicePurchase.updatePurchase(id, put);
        return this.modelMapper.map(
                purchase,
                DtoPurchase.Response.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(
            path = "/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DtoPurchase.Response> findPurchase(@RequestBody DtoPurchase.Get get) {
        return this.servicePurchase.findPurchase(get)
                .stream()
                .map(purchase -> this.modelMapper.map(
                purchase,
                DtoPurchase.Response.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoPurchase.Response findPurchase(@PathVariable Integer id) {
        return this.modelMapper.map(
                this.servicePurchase.findPurchaseById(id),
                DtoPurchase.Response.class);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/list")
    public List<DtoPurchase.Response> PurchaseAll() {
        return this.servicePurchase.listPurchase().stream().map(Purchase -> this.modelMapper.map(
                Purchase,
                DtoPurchase.Response.class))
                .collect(Collectors.toList());
    }

}
