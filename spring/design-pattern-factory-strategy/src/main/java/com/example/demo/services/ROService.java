package com.example.demo.services;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.ErrorMessage;
import com.example.demo.enums.Format;
import com.example.demo.enums.ReadBehavior;
import com.example.demo.enums.ValidateBehavior;
import com.example.demo.formats.factories.IValidateBehaviorFactory;
import com.example.demo.formats.behaviors.IReadBehavior;
import com.example.demo.formats.behaviors.IValidateBehavior;
import com.example.demo.formats.factories.IReadBehaviorFactory;
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
        Format format = Format.getFormatEnum(formatAsString);
        if(format == null) {
            return null;
        }

        ReadBehavior behavior = ReadBehavior.getBehaviorEnum(format);
        if(behavior == null) {
            return null;
        }

        IReadBehavior iReadBehavior = iReadBehaviorFactory.getBehavior(behavior);
        return iReadBehavior.read();
    }

    public List<ErrorMessage> validate(String formatAsString) {
        Format format = Format.getFormatEnum(formatAsString);
        if(format == null) {
            return null;
        }

        ValidateBehavior behavior = ValidateBehavior.getBehaviorEnum(format);
        if(behavior == null) {
            return null;
        }

        IValidateBehavior iValidateBehavior = iValidateBehaviorFactory.getBehavior(behavior);
        return iValidateBehavior.validate();
    }
}
