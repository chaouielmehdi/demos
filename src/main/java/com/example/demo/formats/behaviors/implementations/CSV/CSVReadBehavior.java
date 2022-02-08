package com.example.demo.formats.behaviors.implementations.CSV;

import com.example.demo.dtos.RODto;
import com.example.demo.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component(value = "CSV")
public class CSVReadBehavior implements IReadBehavior {
    @Override
    public RODto read() {
        // 1- read from file
        // 2- construct RODto object
        // 3- return it
        return new RODto(100);
    }
}
