package com.example.demo.formats.factories;

import com.example.demo.enums.FormatEnum;
import com.example.demo.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IReadBehaviorFactory {
    IReadBehavior getReadBehavior(FormatEnum readBehaviorType);
}