package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Essential implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mainEssential",nullable=false,length = 255)
    @Length(min = 0, max = 255)
    private String mainEssential;

    @Column(name = "secondaryEssential",nullable=false,length = 255)
    @Length(min = 0, max = 255)
    private String secondaryEssential;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainEssential() {
        return mainEssential;
    }

    public void setMainEssential(String mainEssential) {
        this.mainEssential = mainEssential;
    }

    public String getSecondaryEssential() {
        return secondaryEssential;
    }

    public void setSecondaryEssential(String secondaryEssential) {
        this.secondaryEssential = secondaryEssential;
    }

    public Essential(String mainEssential, String secondaryEssential) {
        this.mainEssential=mainEssential;
        this.secondaryEssential=secondaryEssential;
    }

    @Override
    public String toString() {
        return "Essential{" +
                "id=" + id +
                ", mainEssential='" + mainEssential + '\'' +
                ", secondaryEssential='" + secondaryEssential + '\'' +
                '}';
    }
}
