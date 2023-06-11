package com.example.demo.formats.factories;

import com.example.demo.enums.ReadBehavior;
import com.example.demo.enums.ValidateBehavior;
import com.example.demo.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IValidateBehaviorFactory {
    IValidateBehavior getBehavior(ValidateBehavior behavior);
}