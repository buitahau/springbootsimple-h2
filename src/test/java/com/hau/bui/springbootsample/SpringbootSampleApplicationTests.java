package com.hau.bui.springbootsample;

import com.hau.bui.springbootsample.controller.HelloWorldController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSampleApplicationTests {

	@Test
	void contextLoads() {
        HelloWorldController helloWorldController = new HelloWorldController();
        Assertions.assertSame(helloWorldController.helloWorld(), "Welcome to Hau kute v1");
	}

}
