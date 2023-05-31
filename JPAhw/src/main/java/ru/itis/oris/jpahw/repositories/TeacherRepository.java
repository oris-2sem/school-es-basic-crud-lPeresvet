package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.users.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
