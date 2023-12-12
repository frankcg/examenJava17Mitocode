package com.frank.laura.examenJava17Mitocode.service.impl;

import com.frank.laura.examenJava17Mitocode.model.Student;
import com.frank.laura.examenJava17Mitocode.repository.IGenericRepo;
import com.frank.laura.examenJava17Mitocode.repository.IStudentRepo;
import com.frank.laura.examenJava17Mitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}
