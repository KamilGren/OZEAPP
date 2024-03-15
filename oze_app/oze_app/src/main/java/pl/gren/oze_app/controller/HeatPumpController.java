package pl.gren.oze_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gren.oze_app.model.EnergyData;
import pl.gren.oze_app.model.HeatPump;
import pl.gren.oze_app.service.HeatPumpService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/api/heatpumps/")
public class HeatPumpController {

    private final HeatPumpService heatPumpService;

    @Autowired
    public HeatPumpController(HeatPumpService heatPumpService) {
        this.heatPumpService = heatPumpService;
    }

    @GetMapping
    public List<HeatPump> getAllHeatPump() {
        return heatPumpService.getAllHeatPump();
    }

    @GetMapping("search/{id}")
    public String showHeatPumpParams(@PathVariable Long id, Model model) {
        HeatPump heatPump = heatPumpService.getHeatPumpById(id).orElseThrow(() -> new NoSuchElementException("Brak tej pompy!"));
        model.addAttribute("heatPump", heatPump); // Dodaj obiekt do Model
        return "heatPumpParams"; // Wyświetl widok
    }



    @GetMapping("/{id}")
    public ResponseEntity<HeatPump> getHeatPumpById(@PathVariable Long id) {
        Optional<HeatPump> pompaCiepła = heatPumpService.getHeatPumpById(id);
        return pompaCiepła.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HeatPump> saveHeatPump(@Valid @RequestBody HeatPump heatPomp) {
        HeatPump savedHeatPump = heatPumpService.saveHeatPump(heatPomp);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHeatPump);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeatPump(@PathVariable Long id) {
        heatPumpService.deleteHeatPump(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/pumps/")
    public String findPumpByProducentModelTyp(Model model2, @RequestParam String producent, @RequestParam String model, @RequestParam String type) {

        List<HeatPump> heatPumps = heatPumpService.getHeatPumpByProducentModelTyp(producent, model, type);

        // Przekaz wyniki do modelu
        model2.addAttribute("heatPumps", heatPumps);

        // Zwróć nazwę widoku Thymeleaf
        return "heatPumpParams";
    }


    @GetMapping("/getProducents")
    public String getHeatPumpByProducent(Model model) {
        List<String> heatPumpsProducents = heatPumpService.getHeatPumpsProducents();
        model.addAttribute("heat_pump", heatPumpsProducents);

        System.out.println(heatPumpsProducents.get(0));
        System.out.println(heatPumpsProducents.get(1));
        System.out.println(heatPumpsProducents.get(2));

        return "heatPumpParams";
    }

    @GetMapping("/getModels")
    public String getHeatPumpModels(Model model1) {
        List<String> heatPumps = heatPumpService.getHeatPumpsModels();
        model1.addAttribute("heat_pump", heatPumps);

        System.out.println(heatPumps.get(0));
        System.out.println(heatPumps.get(1));
        System.out.println(heatPumps.get(2));

        return "heatPumpParams";
    }


    @GetMapping("/getTypes")
    public ResponseEntity<?> getHeatPumpTypesByProducentAndModel(@RequestParam String producent, @RequestParam String model) {


        if (producent != null && model != null) {
            List<String> heatPumpsTypes = heatPumpService.getHeatPumpsTypesByProducentAndModel(producent, model);
            return ResponseEntity.ok().body(heatPumpsTypes);
        } else {

            System.out.println("Producent lub model są puste");
            return ResponseEntity.badRequest().body("Producent or model are empty!");
        }
    }

    @GetMapping("/heatpump-search")
    public String getHeatPumpAndShow(Model model) {

        List<String> heatPumpsProducents = heatPumpService.getHeatPumpsProducents();
        model.addAttribute("heatPumpProducents", heatPumpsProducents);

        List<String> heatPumps = heatPumpService.getHeatPumpsModels();
        model.addAttribute("heatPumpModels", heatPumps);

        return "heatPumpForm";
    }


    @PostMapping("/searchPump")
    public String searchHeatPump(@RequestParam("producent") String producent,
                                            @RequestParam("model") String model,
                                            @RequestParam("typ") String typ,
                                            Model model1) {

        List<HeatPump> heatPumps = heatPumpService.getHeatPumpByProducentModelTyp(producent, model, typ);
        model1.addAttribute("heatPump", heatPumps);

        System.out.println("halo halo");

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location", "/heatPumpParams"); // to szuka kontrolera
        // Dodaj nagłówki i dane do odpowiedzi
        // return new ResponseEntity<>(heatPumps, headers, HttpStatus.FOUND);

        return "heatPumpForm";
    }


}