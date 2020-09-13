package org.example.services;

import org.example.dtos.SumDTO;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String helloWorld() {
        return "Hello World";
    }
    public Integer getSum(SumDTO sumDTO) {
        return sumDTO.getFirstNumber() + sumDTO.getSecondNumber();
    }
}


