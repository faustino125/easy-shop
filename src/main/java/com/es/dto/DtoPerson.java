package com.es.dto;

import lombok.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public interface DtoPerson {

    @Setter
    @Getter
    public class Post {

        private String name;
        private String phone;
        private String address;
        private String nit;
        private String email;
        private String type_id;
    }

    @Setter
    @Getter
    public class Put {

        private String name;
        private String phone;
        private String address;
        private String nit;
        private String email;
        private String type_id;
    }

    @Setter
    @Getter
    public class Get {

        private Integer id_person;
        private String name;
        private String phone;
        private String address;
        private String nit;
        private String email;
        private String type_id;
    }

    @Setter
    @Getter
    public class Response {

        private Integer id_person;
        private String name;
        private String phone;
        private String address;
        private String nit;
        private String email;
        private String type_id;
    }

}
