package br.com.reactivecrud.service.impl;

import br.com.reactivecrud.domain.Student;
import br.com.reactivecrud.repository.StudentRepository;
import br.com.reactivecrud.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository repository;

    @Override
    public Flux<Student> findAll() {
        return repository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Student> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono save(Student student) {
        return repository.save(student);
    }

    @Override
    public Mono update(String id, Student student) {
        return this.repository.findById(id)
                .map(s -> student)
                .flatMap(this.repository::save);
    }

    @Override
    public Mono delete(String id) {
        Mono<Student> studentMono = findById(id);

        return Objects.isNull(studentMono) ? Mono.empty()
                : studentMono.switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull).flatMap(studentDeleted -> repository
                .delete(studentDeleted).then(Mono.just(studentDeleted)));
    }
}
