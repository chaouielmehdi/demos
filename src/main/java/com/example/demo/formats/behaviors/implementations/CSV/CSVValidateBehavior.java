package com.example.demo.formats.behaviors.implementations.CSV;

import com.example.demo.enums.ErrorMessage;
import com.example.demo.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "CSV")
public class CSVValidateBehavior implements IValidateBehavior {
    @Override
    public List<ErrorMessage> validate() {
        // 1- validate RODto
        // 2- return list of errors
        return new ArrayList<>();
    }
}
