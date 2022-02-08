package com.example.demo;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.FormatEnum;
import com.example.demo.controllers.ROController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class SpringDemoApplicationTest {
    @Autowired
    ROController roController;

    @Test
    public void testRODtoIsNull() {
        RODto roDto = roController.read("invalid-format");

        boolean expression = roDto == null;
        String message = "RODto object should be null";
        Assert.state(expression, message);
    }

    @Test
    public void testRODtoIsNotNull() {
        RODto roDto = roController.read("MT101");

        boolean expression = roDto != null;
        String message = "RODto object should be not null";
        Assert.state(expression, message);
    }

    @Test
    public void testRODtoAmountMT101() {
        RODto roDto = roController.read("MT101");

        boolean expression = roDto.getTotalAmount() == 200;
        String message = "Amount is not valid";
        Assert.state(expression, message);
    }

    @Test
    public void testRODtoAmountCSV() {
        RODto roDto = roController.read("CSV");

        boolean expression = roDto.getTotalAmount() == 100;
        String message = "Amount is not valid";
        Assert.state(expression, message);
    }
}
