package com.frank.laura.examenJava17Mitocode.service;

import com.frank.laura.examenJava17Mitocode.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{
    Map<String, Long> getCoursesPerStudent();
}
