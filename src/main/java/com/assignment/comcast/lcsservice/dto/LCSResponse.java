package com.assignment.comcast.lcsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LCSResponse implements Serializable {

    public LCSResponse() {
    }

    public LCSResponse(String message, List<SetOfString> lcs) {
        this.message = message;
        this.lcs = lcs;
    }
    

    private String message;

    private List<SetOfString> lcs;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SetOfString> getLcs() {
        return lcs;
    }

    public void setLcs(List<SetOfString> lcs) {
        this.lcs = lcs;
    }
}
