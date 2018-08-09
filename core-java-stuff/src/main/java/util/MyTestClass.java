package util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class MyTestClass {

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class NestedOne{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    private long id;
    private String name;
    private String notInterstingMember;
    private int anotherMember;
    private int forgetThisField;


    private NestedOne nestedOne;


    public NestedOne getNestedOne() {
        return nestedOne;
    }

    public void setNestedOne(NestedOne nestedOne) {
        this.nestedOne = nestedOne;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotInterstingMember() {
        return this.notInterstingMember;
    }

    public void setNotInterstingMember(String notInterstingMember) {
        this.notInterstingMember = notInterstingMember;
    }

    public int getAnotherMember() {
        return this.anotherMember;
    }

    public void setAnotherMember(int anotherMember) {
        this.anotherMember = anotherMember;
    }

    public int getForgetThisField() {
        return this.forgetThisField;
    }

    public void setForgetThisField(int forgetThisField) {
        this.forgetThisField = forgetThisField;
    }

    @Override
    public String toString() {
        return "MyTestClass [" + this.id + " , " +  this.name + ", " + this.notInterstingMember + ", " + this.anotherMember + ", " + this.forgetThisField + "]";
    }

}
