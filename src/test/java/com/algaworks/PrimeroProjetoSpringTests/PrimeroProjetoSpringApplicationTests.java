package com.algaworks.PrimeroProjetoSpringTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.algaworks.PrimeroProjetoSpring.PrimeroProjetoSpringApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PrimeroProjetoSpringApplication.class)
@WebAppConfiguration
public class PrimeroProjetoSpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}
