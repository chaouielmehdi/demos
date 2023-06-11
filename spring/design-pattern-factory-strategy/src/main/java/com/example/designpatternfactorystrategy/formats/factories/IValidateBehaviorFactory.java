package com.example.designpatternfactorystrategy.formats.factories;

import com.example.designpatternfactorystrategy.enums.ValidateBehavior;
import com.example.designpatternfactorystrategy.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IValidateBehaviorFactory {
    IValidateBehavior getBehavior(ValidateBehavior behavior);
}