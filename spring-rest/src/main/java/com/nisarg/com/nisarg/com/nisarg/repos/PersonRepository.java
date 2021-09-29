package com.nisarg.com.nisarg.com.nisarg.repos;

import com.nisarg.com.nisarg.entities.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
    @Query("SELECT * FROM person WHERE last_name = :lastname")
    Flux<Person> findByLastName(String lastName);
}
