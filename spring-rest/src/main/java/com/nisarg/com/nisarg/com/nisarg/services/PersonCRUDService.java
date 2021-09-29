package com.nisarg.com.nisarg.com.nisarg.services;

import com.nisarg.com.nisarg.com.nisarg.repos.PersonRepository;
import com.nisarg.com.nisarg.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class PersonCRUDService {
    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public Flux<Person> findAll() {
        return personRepository.findAll();
    }
}
