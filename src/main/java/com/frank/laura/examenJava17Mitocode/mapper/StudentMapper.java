package com.frank.laura.examenJava17Mitocode.mapper;

import com.frank.laura.examenJava17Mitocode.dto.StudentDTO;
import com.frank.laura.examenJava17Mitocode.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    Student toStudent(StudentDTO studentDTO);
    StudentDTO toStudentDTO(Student student);
    List<StudentDTO> toStudentListDTO(List<Student> students);
}
