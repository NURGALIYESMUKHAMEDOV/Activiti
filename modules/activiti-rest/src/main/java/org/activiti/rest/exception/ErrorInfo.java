package org.activiti.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
public class ErrorInfo {

    private String message;
    private String exception;

    public ErrorInfo(String message, Exception ex){
        this.message = message;
        if(ex != null){
            this.exception = ex.getLocalizedMessage();
        }
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setException(String exception){
        this.exception = exception;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getException(){
        return exception;
    }
}