package pl.gren.oze_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gren.oze_app.model.Inwerter;

@Repository
public interface InwerterRepository extends JpaRepository<Inwerter, Long> {
    // Dodatkowe zapytania zgodnie z potrzebami
}