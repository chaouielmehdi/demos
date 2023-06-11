package com.example.designpatternfactorystrategy.formats.behaviors.implementations.CSV;

import com.example.designpatternfactorystrategy.enums.ErrorMessage;
import com.example.designpatternfactorystrategy.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "CSVValidateBehavior")
public class CSVValidateBehavior implements IValidateBehavior {
    @Override
    public List<ErrorMessage> validate() {
        // 1- validate RODto
        // 2- return list of errors
        return new ArrayList<>();
    }
}
