package org.example.dtos;

import javax.validation.constraints.NotNull;

public class SumDTO {
    @NotNull(message = "Primeiro numero da soma não pode ser nulo")
    private Integer firstNumber;
    @NotNull(message = "Segundo numero da soma não pode ser nulo")
    private Integer secondNumber;

    public SumDTO(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }
}
