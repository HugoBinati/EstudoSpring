package org.example.controllers;

import org.example.dtos.SumDTO;
import org.example.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    HelloService service;

    @GetMapping(value="hello")
    public String helloWorld() {
        return service.helloWorld();
    }

    @PostMapping(value="hello")
    public Integer sum(@RequestBody @Valid SumDTO sumDTO){
        return service.getSum(sumDTO);
    }
}
