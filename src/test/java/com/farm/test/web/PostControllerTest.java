package com.farm.test.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void index() {
    //when
    String body = this.testRestTemplate.getForObject("/", String.class);
    
    //then
    assertThat(body).contains("스프링");
  }
}