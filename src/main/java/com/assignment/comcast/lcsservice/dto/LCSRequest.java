package com.assignment.comcast.lcsservice.dto;

import java.io.Serializable;
import java.util.List;


public class LCSRequest implements Serializable {

    public LCSRequest() {
    }

    public List<SetOfString> setOfStrings;

    public LCSRequest(List<SetOfString> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }


    public List<SetOfString> getSetOfStrings() {
        return setOfStrings;
    }

    public void setSetOfStrings(List<SetOfString> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    @Override
    public String toString() {
        return "LCSRequest{" +
                "setOfStrings=" + setOfStrings +
                '}';
    }
}
