package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.users.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
