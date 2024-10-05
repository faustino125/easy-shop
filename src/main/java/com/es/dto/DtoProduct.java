package com.es.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.*;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public interface DtoProduct {

    @Setter
    @Getter
    public class Get {

        private Integer id_product;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private Date due_date;
        private String image;
        private String category_id;
        private Integer supplier_id;
    }

    @Setter
    @Getter
    public class Post {

        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private Date due_date;
        private String image;
        private String category_id;
        private Integer supplier_id;
    }

    @Setter
    @Getter
    public class Put {

        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private Date due_date;
        private String image;
        private String category_id;
        private Integer supplier_id;
    }

    @Setter
    @Getter
    public class Response {

        private Integer id_product;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private Date due_date;
        private String image;
        private String category_id;
        private Integer supplier_id;
    }

}
