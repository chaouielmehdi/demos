package com.example.designpatternfactorystrategy.dtos;

public class RODto {
    private int totalAmount;

    public RODto(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
