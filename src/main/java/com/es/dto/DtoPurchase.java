package com.es.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.*;

/*
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public interface DtoPurchase {

    @Setter
    @Getter
    public class Post {

        private Date date;
        private BigDecimal unit_pre;
        private Integer product_id;
        private Integer customer_id;
        private Integer user_id;

    }

    @Setter
    @Getter
    public class Put {

        private Date date;
        private BigDecimal unit_pre;
        private Integer product_id;
        private Integer customer_id;
        private Integer user_id;

    }

    @Setter
    @Getter
    public class Get {
        private Integer purchase_id;
        private Date date;
        private BigDecimal unit_pre;
        private Integer product_id;
        private Integer customer_id;
        private Integer user_id;

    }

    @Setter
    @Getter
    public class Response {

        private Integer purchase_id;
        private Date date;
        private BigDecimal unit_pre;
        private Integer product_id;
        private Integer customer_id;
        private Integer user_id;

    }
}
