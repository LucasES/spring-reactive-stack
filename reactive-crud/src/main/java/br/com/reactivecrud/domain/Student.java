package br.com.reactivecrud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document
public class Student {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private int age;
}
