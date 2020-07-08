package com.dyz.spring_boot_acivemq;

import com.dyz.spring_boot_acivemq.mq.Produce;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class SpringBootAcivemqApplicationTests {

    @Resource
    private Produce produce;

    @Test
    void contextLoads() {
        produce.produceMsg();
    }

}
