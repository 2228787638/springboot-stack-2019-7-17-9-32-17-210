package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.model.Prosecutor;
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
public class ProsecutorRepositoryTest {
    @Autowired
    ProsecutorRepository prosecutorRepository;

    @Before
    public void setUp(){
        List<Prosecutor> prosecutorList =new ArrayList<>();
        prosecutorList.add(new Prosecutor("prosecutor1"));
        prosecutorList.add(new Prosecutor("prosecutor2"));
        prosecutorList.add(new Prosecutor("prosecutor3"));
        prosecutorRepository.saveAll(prosecutorList);
    }
    @Test
    public void should_return_prosecutor_by_caseId(){
        Prosecutor prosecutor = prosecutorRepository.findById(1).get();
        Assert.assertEquals("Prosecutor{id=1, name='prosecutor1'}",prosecutor.toString());
    }
}