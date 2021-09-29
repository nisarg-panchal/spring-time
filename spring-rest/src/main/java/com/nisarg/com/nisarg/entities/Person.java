package com.nisarg.com.nisarg.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    @Id
    private long id;
    private String firstName;
    private String lastName;
}
