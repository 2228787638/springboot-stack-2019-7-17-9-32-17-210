package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Prosecutor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable=false,length = 255)
    @Length(min = 0, max = 255)
    private String name;
}
