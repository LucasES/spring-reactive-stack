package br.com.reactivecrud.repository;

import br.com.reactivecrud.domain.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
}
