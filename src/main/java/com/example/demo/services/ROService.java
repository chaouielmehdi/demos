package com.example.demo.services;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.FormatEnum;
import com.example.demo.formats.behaviors.IReadBehavior;
import com.example.demo.formats.factories.IReadBehaviorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ROService {
    @Autowired
    private IReadBehaviorFactory iReadBehaviorFactory;

    public RODto read(String formatAsString) {
        FormatEnum format = FormatEnum.getFormatEnum(formatAsString);

        IReadBehavior iReadBehavior = iReadBehaviorFactory.getReadBehavior(format);
        return iReadBehavior.read();
    }
}
