package com.frank.laura.examenJava17Mitocode.mapper;

import com.frank.laura.examenJava17Mitocode.dto.EnrollmentDTO;
import com.frank.laura.examenJava17Mitocode.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);
    Enrollment toEnrollment(EnrollmentDTO enrollmentDTO);
    EnrollmentDTO toEnrollmentDTO(Enrollment enrollment);
    List<EnrollmentDTO> toEnrollmentListDTO(List<Enrollment> enrollments);
}
