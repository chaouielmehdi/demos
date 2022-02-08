package com.example.demo.services;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.ErrorMessage;
import com.example.demo.enums.FormatEnum;
import com.example.demo.formats.behaviors.IReadBehavior;
import com.example.demo.formats.behaviors.IValidateBehavior;
import com.example.demo.formats.factories.IReadBehaviorFactory;
import com.example.demo.formats.factories.IValidateBehaviorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ROService {
    @Autowired
    private IReadBehaviorFactory iReadBehaviorFactory;

    @Autowired
    private IValidateBehaviorFactory iValidateBehaviorFactory;

    public RODto read(String formatAsString) {
        FormatEnum format = FormatEnum.getFormatEnum(formatAsString);

        IReadBehavior iReadBehavior = iReadBehaviorFactory.getBehavior(format);
        return iReadBehavior.read();
    }

    public List<ErrorMessage> validate(String formatAsString) {
        FormatEnum format = FormatEnum.getFormatEnum(formatAsString);

        IValidateBehavior iValidateBehavior = iValidateBehaviorFactory.getBehavior(format);
        return iValidateBehavior.validate();
    }
}
