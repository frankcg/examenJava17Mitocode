package com.frank.laura.examenJava17Mitocode.controller;


import com.frank.laura.examenJava17Mitocode.dto.StudentDTO;
import com.frank.laura.examenJava17Mitocode.mapper.StudentMapper;
import com.frank.laura.examenJava17Mitocode.model.Student;
import com.frank.laura.examenJava17Mitocode.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        return new ResponseEntity<>(StudentMapper.INSTANCE.toStudentListDTO(service.readAll().stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList())), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(StudentMapper.INSTANCE.toStudentDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
        return new ResponseEntity<>(StudentMapper.INSTANCE.toStudentDTO(service.save(StudentMapper.INSTANCE.toStudent(dto))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto, @PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(StudentMapper.INSTANCE.toStudentDTO(service.update(StudentMapper.INSTANCE.toStudent(dto),id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
