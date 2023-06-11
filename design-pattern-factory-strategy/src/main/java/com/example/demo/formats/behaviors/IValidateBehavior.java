package com.example.demo.formats.behaviors;

import com.example.demo.enums.ErrorMessage;

import java.util.List;

public interface IValidateBehavior {
    List<ErrorMessage> validate();
}
