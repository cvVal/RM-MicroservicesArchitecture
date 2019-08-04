package com.web.services.restfuludemycurse.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//This is one approach to exclude properties from the response in a static way
//@JsonIgnoreProperties(value = {"field1", "field3"})
@JsonFilter("SomeBeanFilter")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class SomeBean {

    private String field1;
    private String field2;

    //This is one approach to exclude this property from the response in a static way
    //@JsonIgnore
    private String field3;
}