package com.example.designpatternfactorystrategy.formats.behaviors.implementations.CSV;

import com.example.designpatternfactorystrategy.dtos.RODto;
import com.example.designpatternfactorystrategy.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component(value = "CSVReadBehavior")
public class CSVReadBehavior implements IReadBehavior {
    @Override
    public RODto read() {
        // 1- read from file
        // 2- construct RODto object
        // 3- return it
        return new RODto(100);
    }
}
