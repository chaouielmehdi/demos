package com.example.demo.controllers;

import com.example.demo.dtos.RODto;
import com.example.demo.enums.ErrorMessage;
import com.example.demo.services.ROService;
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
