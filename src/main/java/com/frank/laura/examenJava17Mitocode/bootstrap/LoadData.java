package com.frank.laura.examenJava17Mitocode.bootstrap;

import com.frank.laura.examenJava17Mitocode.model.Course;
import com.frank.laura.examenJava17Mitocode.model.Enrollment;
import com.frank.laura.examenJava17Mitocode.model.EnrollmentDetail;
import com.frank.laura.examenJava17Mitocode.model.Student;
import com.frank.laura.examenJava17Mitocode.repository.ICourseRepo;
import com.frank.laura.examenJava17Mitocode.repository.IEnrollmentRepo;
import com.frank.laura.examenJava17Mitocode.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.CoderResult;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class LoadData implements CommandLineRunner {
	
	@Autowired
	IStudentRepo iStudentRepo;

	@Autowired
	ICourseRepo iCourseRepo;

	@Autowired
	IEnrollmentRepo iEnrollmentRepo;

	@Override
	public void run(String... args) throws Exception {
		loadStudent();
		loadCourse();
		loadEnrollment();
	}
	
	private void loadStudent() {
        if (iStudentRepo.count() == 0) {
			iStudentRepo.save(
					Student.builder()
							.name("FRANK")
							.lastName("LAURA BORJA")
							.documentNumber("73191639")
							.age(28)
							.build()
            );

			iStudentRepo.save(
					Student.builder()
							.name("THIAGO")
							.lastName("LAURA AYALA")
							.documentNumber("92455122")
							.age(25)
							.build()
			);

			iStudentRepo.save(
					Student.builder()
							.name("RENE RAMON")
							.lastName("LAURA QUISPE")
							.documentNumber("25732120")
							.age(55)
							.build()
			);

            System.out.println("Load Student");
        }
    }

	private void loadCourse() {
		if (iCourseRepo.count() == 0) {
			iCourseRepo.save(
					Course.builder()
							.name("JAVA PROGRAMMER")
							.acronym("JAVA")
							.enabled(true)
							.build()
			);

			iCourseRepo.save(
					Course.builder()
							.name("PYTHON PROGRAMMER")
							.acronym("PYTHON")
							.enabled(true)
							.build()
			);

			iCourseRepo.save(
					Course.builder()
							.name("DATA BASE ADMINISTRATOR")
							.acronym("DBA")
							.enabled(true)
							.build()
			);

			System.out.println("Load Course");
		}
	}

	private void loadEnrollment() {

		if (iEnrollmentRepo.count() == 0) {

			ArrayList<EnrollmentDetail> enrollmentDetails1 = new ArrayList<>();
			enrollmentDetails1.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(1).build())
					.course(Course.builder().idCourse(1).build())
					.classroom("708 A")
					.build());
			enrollmentDetails1.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(1).build())
					.course(Course.builder().idCourse(2).build())
					.classroom("710 A")
					.build());

			iEnrollmentRepo.save(
					Enrollment.builder()
							.idEnrollment(1)
							.dateTime(LocalDateTime.now())
							.enabled(true)
							.student(Student.builder().idStudent(1).build())
							.details(enrollmentDetails1)
							.build()
			);

			ArrayList<EnrollmentDetail> enrollmentDetails2 = new ArrayList<>();
			enrollmentDetails2.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(2).build())
					.course(Course.builder().idCourse(2).build())
					.classroom("710 A")
					.build());

			enrollmentDetails2.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(2).build())
					.course(Course.builder().idCourse(3).build())
					.classroom("910 B")
					.build());

			iEnrollmentRepo.save(
					Enrollment.builder()
							.idEnrollment(2)
							.dateTime(LocalDateTime.now())
							.enabled(true)
							.student(Student.builder().idStudent(2).build())
							.details(enrollmentDetails2)
							.build()
			);

			ArrayList<EnrollmentDetail> enrollmentDetails3 = new ArrayList<>();
			enrollmentDetails3.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(3).build())
					.course(Course.builder().idCourse(1).build())
					.classroom("708 A")
					.build());

			enrollmentDetails3.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(3).build())
					.course(Course.builder().idCourse(2).build())
					.classroom("710 A")
					.build());

			enrollmentDetails3.add(EnrollmentDetail.builder()
					.enrollment(Enrollment.builder().idEnrollment(3).build())
					.course(Course.builder().idCourse(3).build())
					.classroom("910 B")
					.build());

			iEnrollmentRepo.save(
					Enrollment.builder()
							.idEnrollment(3)
							.dateTime(LocalDateTime.now())
							.enabled(true)
							.student(Student.builder().idStudent(3).build())
							.details(enrollmentDetails3)
							.build()
			);

			System.out.println("Load Enrollment");
		}
	}
	
	
}
