package com.example.demo.services;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.Behavior;
import com.example.demo.enums.ErrorMessage;
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
        String formatAndBehavior = Behavior.combineFormatAndBehavior(formatAsString, Behavior.ReadBehavior);

        IReadBehavior iReadBehavior = iReadBehaviorFactory.getBehavior(formatAndBehavior);
        return iReadBehavior.read();
    }

    public List<ErrorMessage> validate(String formatAsString) {
        String formatAndBehavior = Behavior.combineFormatAndBehavior(formatAsString, Behavior.ValidateBehavior);

        IValidateBehavior iValidateBehavior = iValidateBehaviorFactory.getBehavior(formatAndBehavior);
        return iValidateBehavior.validate();
    }
}
