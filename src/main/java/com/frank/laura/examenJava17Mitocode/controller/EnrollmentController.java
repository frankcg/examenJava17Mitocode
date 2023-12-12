package com.frank.laura.examenJava17Mitocode.controller;

import com.frank.laura.examenJava17Mitocode.dto.EnrollmentDTO;
import com.frank.laura.examenJava17Mitocode.model.Enrollment;
import com.frank.laura.examenJava17Mitocode.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping("/getCoursesPerStudent")
    public ResponseEntity<Map<String, Long>> getCoursesPerStudent() throws Exception{
        return new ResponseEntity<>(service.getCoursesPerStudent(), HttpStatus.OK);
        //return new ResponseEntity<>(EnrollmentMapper.INSTANCE.toEnrollmentListDTO(service.readAll()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{
        return new ResponseEntity<>(service.readAll().stream().map(this::convertToDto).toList(), HttpStatus.OK);
        //return new ResponseEntity<>(EnrollmentMapper.INSTANCE.toEnrollmentListDTO(service.readAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(convertToDto(service.readById(id)), HttpStatus.OK);
        //return new ResponseEntity<>(EnrollmentMapper.INSTANCE.toEnrollmentDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        return new ResponseEntity<>(convertToDto(service.save(convertToEntity(dto))), HttpStatus.CREATED);
        //return new ResponseEntity<>(EnrollmentMapper.INSTANCE.toEnrollmentDTO(service.save(EnrollmentMapper.INSTANCE.toEnrollment(dto))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @RequestBody EnrollmentDTO dto, @PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(convertToDto(service.update(convertToEntity(dto), id)), HttpStatus.OK);
        //return new ResponseEntity<>(EnrollmentMapper.INSTANCE.toEnrollmentDTO(service.update(EnrollmentMapper.INSTANCE.toEnrollment(dto),id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private EnrollmentDTO convertToDto(Enrollment obj){
        return mapper.map(obj, EnrollmentDTO.class);
    }

    private Enrollment convertToEntity(EnrollmentDTO dto){
        return mapper.map(dto, Enrollment.class);
    }

}
