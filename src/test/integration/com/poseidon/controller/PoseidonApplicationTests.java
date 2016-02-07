package com.poseidon.controller;


import com.poseidon.PoseidonApplication;
import com.poseidon.WebSecurityConfig;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {PoseidonApplication.class, WebSecurityConfig.class})
@IntegrationTest({"server.port=8081"})
@WebAppConfiguration
public class PoseidonApplicationTests {


}