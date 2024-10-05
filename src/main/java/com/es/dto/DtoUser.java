package com.es.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public interface DtoUser {

    @Setter
    @Getter
    public class Post {

        private String user;
        private String pass;
        private Integer person_id;
        private String rol_id;

    }

    @Setter
    @Getter
    public class Put {

        private String user;
        private String pass;
        private Boolean status;
        private Integer person_id;
        private String rol_id;

    }

    @Setter
    @Getter
    public class Get {

        private Integer user_id;
        private String user;
        private String pass;
        private Boolean status;
        private Integer person_id;
        private String rol_id;

    }

    @Setter
    @Getter
    public class Response {

        private Integer user_id;
        private String user;
        private String pass;
        private Boolean status;
        private Integer person_id;
        private String rol_id;

    }
}
