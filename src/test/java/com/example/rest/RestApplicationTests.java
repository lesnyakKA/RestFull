
package com.example.rest;

import com.example.rest.controller.BookController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestApplicationTests {
	@Autowired
	private BookController bookController;
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}
}
