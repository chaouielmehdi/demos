package com.example.demo.controllers;

import com.example.demo.dtos.RODto;
import com.example.demo.services.ROService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ROController {
    @Autowired
    ROService roService;

    /**
     * An end point to read RO
     * @param formatAsString from controller's client
     * @return RODto
     */
    public RODto read(String formatAsString) {
        return roService.read(formatAsString);
    }
}
