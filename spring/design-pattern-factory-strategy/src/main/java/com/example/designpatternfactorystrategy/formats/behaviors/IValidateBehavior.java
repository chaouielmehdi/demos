package com.example.designpatternfactorystrategy.formats.behaviors;

import com.example.designpatternfactorystrategy.enums.ErrorMessage;

import java.util.List;

public interface IValidateBehavior {
    List<ErrorMessage> validate();
}
