package com.nongguoguo.Website.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloomTest {

    @Test
    public void test(){
        Bloom bloom=new Bloom();
        bloom.put("Hello");
        bloom.put("world");
        bloom.put("friend");
        bloom.put("family");
        bloom.put("future");
        System.out.println(bloom.isMaybeExist("world"));
        System.out.println(bloom.isMaybeExist("poor"));
        System.out.println(bloom.isMaybeExist("future"));

    }


}