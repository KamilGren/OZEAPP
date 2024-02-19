package pl.gren.oze_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gren.oze_app.model.BuildingRequirements;

import java.util.Optional;

@Repository
public interface BuildingRequirementsRepository extends JpaRepository<BuildingRequirements, Long> {

    Optional<BuildingRequirements> findByLocation(String location);
}
