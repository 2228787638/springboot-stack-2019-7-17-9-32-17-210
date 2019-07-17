package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.model.Prosecutor;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProcuratorateRepositoryTest {
    @Autowired
    ProcuratorateRepository procuratorateRepository;
    
    @Before
    public void setUp(){
        List<Procuratorate> procuratorates =new ArrayList<>();
        procuratorates.add(new Procuratorate("Procuratorate1"));
        procuratorates.add(new Procuratorate("Procuratorate2"));
        procuratorates.add(new Procuratorate("Procuratorate3"));
        procuratorates.add(new Procuratorate("Procuratorate4",new Prosecutor("prosecutor")));
        procuratorateRepository.saveAll(procuratorates);
    }
    @Test
    public void should_return_case_by_caseId(){
        Procuratorate firstProcuratorate = procuratorateRepository.findById(1).get();
        System.out.println(firstProcuratorate.toString());
        Assert.assertEquals("Procuratorate{id=1, name='Procuratorate1'}",firstProcuratorate.toString());
    }
    @Test
    public void should_contain_procuratorate_when_request_case(){
        Assertions.assertNotNull(procuratorateRepository.findById(4).get().getProsecutor());
    }
}