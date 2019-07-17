package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Case implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "caseName",nullable=false,length = 255)
    @Length(min = 0, max = 255)
    private String caseName;

    @Column(name = "happenTime",nullable=false)
    private long happenTime;

    @OneToOne
    private Essential essential;

    @ManyToOne(fetch=FetchType.LAZY,targetEntity = Procuratorate.class)
    @JoinColumn(name = "procuratorateId",referencedColumnName = "id")
    private Procuratorate procuratorate;

    public Case(String caseName, long happenTime) {
        this.caseName=caseName;
        this.happenTime=happenTime;
    }

    public Case(@Length(min = 0, max = 255) String caseName, long happenTime, Procuratorate procuratorate) {
        this.caseName = caseName;
        this.happenTime = happenTime;
        this.procuratorate = procuratorate;
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

    public Essential getEssential() {
        return essential;
    }

    public void setEssential(Essential essential) {
        this.essential = essential;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", caseName='" + caseName + '\'' +
                ", happenTime=" + happenTime +
                '}';
    }
}
