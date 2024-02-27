package ru.ivankrn.footballercatalog.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivankrn.footballercatalog.database.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
