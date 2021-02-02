package br.com.reactivecrud.controller;

import br.com.reactivecrud.domain.Student;
import br.com.reactivecrud.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {

    private final IStudentService service;

    @GetMapping
    public Flux<Student> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Mono getById(@PathVariable("id") final String id) {
        return service.findById(id);
    }
    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Student student) {
        return service.update(id, student);
    }

    @PostMapping
    public Mono save(@RequestBody final Student student) {
        return service.save(student);
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable final String id) {
        return service.delete(id);
    }
}
