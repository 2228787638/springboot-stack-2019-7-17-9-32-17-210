package com.tw.apistackbase.repository;

import com.sun.deploy.util.StringUtils;
import com.tw.apistackbase.model.Case;
import net.sf.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        caseList.add(new Case("case1",1));
        caseList.add(new Case("case2",2));
        caseList.add(new Case("case3",3));
        caseRepository.saveAll(caseList);
    }

    @Test
    public void should_return_case_by_caseId(){
        Case firstCase = caseRepository.findById(1).get();
        Assert.assertEquals("case1",firstCase.getCaseName());
    }
    @Test
    public void should_return_cases_order_by_happened_time(){
        List<Case> cases=caseRepository.findAllByOrderByHappenTimeDesc();
        Assert.assertEquals("[{\"caseName\":\"case3\",\"happenTime\":3,\"id\":3}," +
                "{\"caseName\":\"case2\",\"happenTime\":2,\"id\":2},{\"caseName\":\"case1\"," +
                "\"happenTime\":1,\"id\":1}]",JSONArray.fromObject(cases).toString());
    }
    @Test
    public void should_return_case_by_caseName(){
        Case actualCase=caseRepository.findByCaseName("case1");
        Case expectedCase = caseRepository.findAll().get(0);
        Assert.assertEquals(expectedCase,actualCase);
    }

    

}