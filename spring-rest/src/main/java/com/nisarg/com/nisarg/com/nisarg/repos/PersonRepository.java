package com.nisarg.com.nisarg.com.nisarg.repos;

import com.nisarg.com.nisarg.entities.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    @Query("SELECT * FROM person WHERE last_name = :lastname")
    Flux<Person> findByLastName(String lastName);
}
