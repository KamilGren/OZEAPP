package pl.gren.oze_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.gren.oze_app.model.HeatPump;


import java.util.List;

public interface HeatPumpRepository extends JpaRepository<HeatPump, Long> {

    public static final String FIND_PRODUCENTS = "SELECT Producent FROM heat_pump";
    public static final String FIND_MODELS = "SELECT model FROM heat_pump";
    public static final String FIND_TYP = "SELECT DISTINCT typ FROM heat_pump WHERE producent = :producent AND model = :model";


    List<HeatPump> getHeatPumpByProducentAndModelAndTyp(String producent, String model, String typ);


    @Query(value = FIND_PRODUCENTS, nativeQuery = true)
    public List<String> findHeatPumpsProducents();

    @Query(value = FIND_MODELS, nativeQuery = true)
    public List<String> findHeatPumpsModels();

    @Query(value = FIND_TYP, nativeQuery = true)
    public List<String> findHeatPumpsTypesByProducentAndModel(@Param("producent") String producent, @Param("model") String model);

    public List<HeatPump> findHeatPumpByProducent(String producent);

    public List<HeatPump> findHeatPumpByProducentAndModel(String producent, String model);












}