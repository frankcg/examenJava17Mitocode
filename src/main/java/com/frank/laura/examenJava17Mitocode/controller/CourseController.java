package com.frank.laura.examenJava17Mitocode.controller;

import com.frank.laura.examenJava17Mitocode.dto.CourseDTO;
import com.frank.laura.examenJava17Mitocode.mapper.CourseMapper;
import com.frank.laura.examenJava17Mitocode.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
        return new ResponseEntity<>(CourseMapper.INSTANCE.toCourseListDTO(service.readAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(CourseMapper.INSTANCE.toCourseDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        return new ResponseEntity<>(CourseMapper.INSTANCE.toCourseDTO(service.save(CourseMapper.INSTANCE.toCourse(dto))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO dto, @PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(CourseMapper.INSTANCE.toCourseDTO(service.update(CourseMapper.INSTANCE.toCourse(dto),id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
