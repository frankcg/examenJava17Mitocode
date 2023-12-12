package com.frank.laura.examenJava17Mitocode.service.impl;

import com.frank.laura.examenJava17Mitocode.model.Enrollment;
import com.frank.laura.examenJava17Mitocode.model.EnrollmentDetail;
import com.frank.laura.examenJava17Mitocode.model.Student;
import com.frank.laura.examenJava17Mitocode.repository.IEnrollmentRepo;
import com.frank.laura.examenJava17Mitocode.repository.IGenericRepo;
import com.frank.laura.examenJava17Mitocode.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toMap;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, Long> getCoursesPerStudent() {
        Stream<Enrollment> saleStream = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> lsStream = saleStream.map(Enrollment::getDetails); //s -> s.getDetails()
        Stream<EnrollmentDetail> streamDetail = lsStream.flatMap(Collection::stream); //list -> list.stream()
        Map<String, Long> byCourse = streamDetail
                .collect(groupingBy(d -> d.getCourse().getName(), counting()));

        System.out.println(byCourse);

        Stream<Enrollment> saleStream2 = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> lsStream2 = saleStream2.map(Enrollment::getDetails);
        Stream<EnrollmentDetail> streamDetail2 = lsStream2.flatMap(Collection::stream);
        Map<String, Long> byStudent = streamDetail2
                .collect(groupingBy(d -> d.getEnrollment().getStudent().getName(), counting()));

        System.out.println(byStudent);

        return byCourse.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new //new LinkedHashMap<>()
                ));
    }

}
