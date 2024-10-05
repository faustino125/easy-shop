package com.es.dto;

import lombok.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public interface DtoCatalog {

    @Setter
    @Getter
    public class Get {

        private String id;
        private String name;
        private String description;
        private String type;
    }

    @Setter
    @Getter
    public class Response {

        private String id;
        private String name;
        private String description;
        private String type;
    }

}
