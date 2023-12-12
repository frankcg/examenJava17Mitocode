package com.frank.laura.examenJava17Mitocode.service.impl;

import com.frank.laura.examenJava17Mitocode.model.Course;
import com.frank.laura.examenJava17Mitocode.repository.ICourseRepo;
import com.frank.laura.examenJava17Mitocode.repository.IGenericRepo;
import com.frank.laura.examenJava17Mitocode.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
