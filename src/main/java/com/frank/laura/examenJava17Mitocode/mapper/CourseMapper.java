package com.frank.laura.examenJava17Mitocode.mapper;

import com.frank.laura.examenJava17Mitocode.dto.CourseDTO;
import com.frank.laura.examenJava17Mitocode.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    Course toCourse(CourseDTO courseDTO);
    CourseDTO toCourseDTO(Course course);
    List<CourseDTO> toCourseListDTO(List<Course> courses);
}
