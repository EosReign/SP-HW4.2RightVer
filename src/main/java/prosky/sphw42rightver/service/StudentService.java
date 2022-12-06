package prosky.sphw42rightver.service;

import org.springframework.stereotype.Service;
import prosky.sphw42rightver.entity.Faculty;
import prosky.sphw42rightver.entity.Student;
import prosky.sphw42rightver.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final FacultyService facultyService;
    private final StudentRepository studentRepository;

    public StudentService(FacultyService facultyService, StudentRepository studentRepository) {
        this.facultyService = facultyService;
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findStudentsByAgeDiapason(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<Student> findStudentsByFaculty(long id) {
        return studentRepository.findStudentByFaculty_Id(id);
    }

    public Faculty getFacultyByStudent(long id) {
        Student student = getStudent(id);
        Collection<Faculty> faculties = facultyService.getAll();
        return faculties.stream().filter(faculty -> faculty.getStudents().contains(student))
                .findFirst().orElse(null);
    }

    public Integer getAmountOfStudents() {
        return studentRepository.getAmountOfStudents();
    }

    public Double getAverageAgeOfStudents() {
        return studentRepository.getAverageAgeOfStudents();
    };

    public List<Student> getLastFiveOfStudentsById() {
        return studentRepository.getLastOfStudentsById();
    }
}
