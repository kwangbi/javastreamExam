package com.example.javastream.controller;

import com.example.javastream.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class DemoController {

    final DemoService demoService;

    @GetMapping("/get/demo")
    public Object getDemo(){
        return demoService.getDemo();
    }

    @GetMapping("/get/demo2")
    public Object getDemo2(){
        return demoService.getDemo2();
    }
}
