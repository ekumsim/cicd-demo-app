package com.demo.cicdapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SimpleRestController {
    
    @GetMapping
    public String hello(){
        return "Hello"+" from Version3!";
    }

    @GetMapping("/{something}")
    public String helloSomethig(@PathVariable String something){
        if(something==null || something.equals("null")){
            return "Can't say Hello to NULL Dude!";
        }
        return "Hello "+something+"!";
    }
}
