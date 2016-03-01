package com.poseidon.controller;


import com.poseidon.PoseidonApplication;
import com.poseidon.WebSecurityConfig;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringApplicationConfiguration(classes = {PoseidonApplication.class, WebSecurityConfig.class})
@WebIntegrationTest("server.port:0")
@DirtiesContext
public class PoseidonApplicationTests extends AbstractTestNGSpringContextTests {


}