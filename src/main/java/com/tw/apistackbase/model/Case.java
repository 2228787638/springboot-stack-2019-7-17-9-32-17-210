package com.tw.apistackbase.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Case implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "caseName",nullable=false,length = 255)
    private String caseName;

    @Column(name = "happenTime",nullable=false)
    private long happenTime;

    public Case(String caseName, long happenTime) {
        this.caseName=caseName;
        this.happenTime=happenTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public long getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(long happenTime) {
        this.happenTime = happenTime;
    }
}
