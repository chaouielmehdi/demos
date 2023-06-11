package com.example.designpatternfactorystrategy.controllers;

import com.example.designpatternfactorystrategy.dtos.RODto;
import com.example.designpatternfactorystrategy.enums.ErrorMessage;
import com.example.designpatternfactorystrategy.services.ROService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ROController {
    @Autowired
    ROService roService;

    public RODto read(String formatAsString) {
        return roService.read(formatAsString);
    }

    public List<ErrorMessage> validate(String formatAsString) {
        return roService.validate(formatAsString);
    }
}
