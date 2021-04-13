package com.assignment.comcast.lcsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetOfString{

    public SetOfString() {
    }

    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
