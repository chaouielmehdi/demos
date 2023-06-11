package com.example.demo.formats.factories;

import com.example.demo.enums.ReadBehavior;
import com.example.demo.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component
public interface IReadBehaviorFactory {
    IReadBehavior getBehavior(ReadBehavior behavior);
}