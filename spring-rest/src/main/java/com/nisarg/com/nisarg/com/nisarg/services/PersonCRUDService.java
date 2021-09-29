package com.nisarg.com.nisarg.com.nisarg.services;

import com.nisarg.com.nisarg.com.nisarg.repos.PersonRepository;
import com.nisarg.com.nisarg.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }

    public Mono<Person> update(Long id, Person person) {
        return personRepository.findById(id).flatMap(personObj -> {
            personObj.setId(personObj.getId());
            return personRepository.save(person);
        });
    }

    public Mono<Void> delete(Person person) {
        return personRepository.delete(person);
    }
}
