package com.es.rest;

import com.es.dto.DtoCatalog;
import com.es.servicio.ServiceCatalog;
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
@Tag(name = "Catalog", description = "Catalog rest")
@RestController
@RequestMapping("/catalog")
public class CatalogRest {

    @Resource
    private ModelMapper modelMapper;

    @Resource
    private ServiceCatalog serviceCatalog;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DtoCatalog.Response find(@PathVariable String id) {
        return this.modelMapper.map(
                this.serviceCatalog.findCatalogId(id),
                DtoCatalog.Response.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DtoCatalog.Response> find(@RequestBody DtoCatalog.Get get) {
        return this.serviceCatalog.findCatalog(get)
                .stream()
                .map(catalog -> this.modelMapper.map(
                catalog,
                DtoCatalog.Response.class))
                .collect(Collectors.toList());
    }

}
