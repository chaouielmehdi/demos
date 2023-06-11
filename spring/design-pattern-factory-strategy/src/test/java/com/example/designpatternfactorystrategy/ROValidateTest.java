package com.example.designpatternfactorystrategy;

import com.example.designpatternfactorystrategy.controllers.ROController;
import com.example.designpatternfactorystrategy.enums.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class ROValidateTest {
    @Autowired
    ROController roController;

    @Test
    public void test_validate_with_invalid_format() {
        List<ErrorMessage> errorMessages = roController.validate("invalid-format");

        boolean expression = errorMessages == null;
        String message = "errorMessages should be null";
        Assert.state(expression, message);
    }

    @Test
    public void test_validate_with_valid_format() {
        List<ErrorMessage> errorMessages = roController.validate("CSV");

        boolean expression = errorMessages != null;
        String message = "errorMessages should not be null";
        Assert.state(expression, message);
    }
}
