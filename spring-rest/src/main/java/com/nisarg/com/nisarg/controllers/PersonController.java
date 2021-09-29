package com.nisarg.com.nisarg.controllers;

import com.nisarg.com.nisarg.com.nisarg.services.PersonCRUDService;
import com.nisarg.com.nisarg.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonCRUDService personCRUDService;

    @GetMapping
    public Flux<Person> getAll() {
        return personCRUDService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> getById(@PathVariable Long id) {
        return personCRUDService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Person> add(@RequestBody Person person) {
        return personCRUDService.save(person);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Person>> update(@PathVariable Long id, @RequestBody Person person) {
        return personCRUDService.update(id, person).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable long id) {
        return personCRUDService.findById(id).flatMap(
                        person -> personCRUDService.delete(person).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
