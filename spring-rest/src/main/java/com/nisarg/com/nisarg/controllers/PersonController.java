package com.nisarg.com.nisarg.controllers;

import com.nisarg.com.nisarg.com.nisarg.repos.PersonRepository;
import com.nisarg.com.nisarg.com.nisarg.services.PersonCRUDService;
import com.nisarg.com.nisarg.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class PersonController {
    @Autowired
    private PersonCRUDService personCRUDService;

    @GetMapping("/persons")
    public Flux<Person> getAll() {
        return personCRUDService.findAll();
    }
}
