package com.example.demo.formats.factories;

import com.example.demo.enums.FormatEnum;
import com.example.demo.formats.behaviors.IReadBehavior;
import com.example.demo.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IValidateBehaviorFactory {
    IValidateBehavior getBehavior(FormatEnum behaviorType);
}