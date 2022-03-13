package com.barcom.pbiDataSynchronizer.utilities;

import org.springframework.http.HttpStatus;

public class ApiResponseBody {
    private HttpStatus status;



    private String description;

    public ApiResponseBody(){
        status = HttpStatus.OK;
    }

    public void setResponseBody(HttpStatus status,String description){
        this.description = description;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
