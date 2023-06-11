package com.example.designpatternfactorystrategy.formats.factories;

import com.example.designpatternfactorystrategy.enums.ReadBehavior;
import com.example.designpatternfactorystrategy.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IReadBehaviorFactory {
    IReadBehavior getBehavior(ReadBehavior behavior);
}