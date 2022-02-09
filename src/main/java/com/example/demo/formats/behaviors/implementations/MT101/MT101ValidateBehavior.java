package com.example.demo.formats.behaviors.implementations.MT101;

import com.example.demo.enums.ErrorMessage;
import com.example.demo.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "MT101ValidateBehavior")
public class MT101ValidateBehavior implements IValidateBehavior {
    @Override
    public List<ErrorMessage> validate() {
        // 1- validate RODto
        // 2- return list of errors
        return new ArrayList<>();
    }
}