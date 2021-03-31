package com.playzone.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data @Entity @Table(schema = "patients")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Address {
	
	@Id @JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    @OneToOne @JsonIgnore
    private Patient patient; 
    private String state; 
    private String city; 
    private String street; 
    private String zipcode;

}
