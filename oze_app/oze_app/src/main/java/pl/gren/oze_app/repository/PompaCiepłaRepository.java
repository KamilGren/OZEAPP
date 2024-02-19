package pl.gren.oze_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gren.oze_app.model.PompaCiepła;

public interface PompaCiepłaRepository extends JpaRepository<PompaCiepła, Long> {
    // Możesz dodać własne metody zapytań, jeśli są potrzebne
}