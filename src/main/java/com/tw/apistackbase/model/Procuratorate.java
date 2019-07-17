package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable=false,unique = true,length = 50)
    @Length(min = 0, max = 50)
    private String name;

    public Procuratorate(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "Procuratorate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
