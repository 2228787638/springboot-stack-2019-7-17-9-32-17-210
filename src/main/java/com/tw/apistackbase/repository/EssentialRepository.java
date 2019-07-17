package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Essential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EssentialRepository extends JpaRepository<Essential,Integer> {
    List<Essential> findAllBy$caseIsNotNull();
}
