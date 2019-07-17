package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Essential;
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
public class EssentialRepositoryTest {
    @Autowired
    EssentialRepository essentialRepository;

    @Before
    public void setUp(){
        List<Essential> essentialList =new ArrayList<>();
        essentialList.add(new Essential("mainEssential1","secondaryEssential1"));
        essentialList.add(new Essential("mainEssential2","secondaryEssential2"));
        essentialList.add(new Essential("mainEssential3","secondaryEssential3"));
        essentialRepository.saveAll(essentialList);
    }

    @Test
    public void should_return_case_by_essentialId(){
        Essential firstEssentia = essentialRepository.findById(1).get();
        System.out.println(firstEssentia.toString());
        Assert.assertEquals("Essential{id=1, mainEssential='mainEssential1', secondaryEssential='secondaryEssential1'}"
                ,firstEssentia.toString());
    }
}