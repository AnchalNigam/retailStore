package com.preplaced.retailStoreDiscount.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private int status;
    private String message;
    private Object data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(HttpStatus status, String message, Object data) {
        super();
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse [status = " + status + ", message = " + message + ", data = " + data + "]";
    }




}
