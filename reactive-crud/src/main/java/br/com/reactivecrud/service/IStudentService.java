package br.com.reactivecrud.service;

import br.com.reactivecrud.domain.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStudentService {

    Flux<Student> findAll();

    Mono<Student> findById(final String id);

    Mono save(final Student student);

    Mono update(final String id, final Student student);

    Mono delete(final String id);
}
