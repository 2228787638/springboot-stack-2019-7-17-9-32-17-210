package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yif
 */
public interface CaseRepository extends JpaRepository<Case,Integer>{

    List<Case> findAllByOrderByHappenTimeDesc();
}
