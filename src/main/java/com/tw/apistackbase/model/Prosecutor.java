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

    public Prosecutor(@Length(min = 0, max = 255) String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Prosecutor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
