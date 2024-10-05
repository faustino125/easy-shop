package com.es.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
public class ExceptionError extends ResponseStatusException{
    
    public ExceptionError(HttpStatusCode status, String reason) {
        super(status, reason);
    }
    
    public ExceptionError(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    
}
