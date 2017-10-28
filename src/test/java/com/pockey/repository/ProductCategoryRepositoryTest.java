package com.pockey.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/10/27 21:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        System.out.println(repository.findByCategoryTypeIn(Arrays.asList(1,2,3)).size());
    }

}