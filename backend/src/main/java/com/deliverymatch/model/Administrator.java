package com.deliverymatch.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMINISRATOR")
public class Administrator extends User {

}
