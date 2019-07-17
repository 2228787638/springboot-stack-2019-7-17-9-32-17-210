package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CaseRepositoryTest {
    @Autowired
    CaseRepository caseRepository;

    @Before
    public void setUp(){
        List<Case> caseList =new ArrayList<>();
        caseList.add(new Case("case1",System.currentTimeMillis()));
        caseList.add(new Case("case2",System.currentTimeMillis()));
        caseList.add(new Case("case3",System.currentTimeMillis()));
        caseRepository.saveAll(caseList);
    }

    @Test
    public void should_return_case_by_caseId(){
        Case firstCase = caseRepository.findById(1).get();
        Assert.assertEquals("case1",firstCase.getCaseName());
    }
}