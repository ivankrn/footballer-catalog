package ru.ivankrn.footballercatalog.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivankrn.footballercatalog.database.model.Footballer;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
