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
}
