package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.users.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
