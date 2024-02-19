package pl.gren.oze_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gren.oze_app.model.ZasobnikCWU;
import pl.gren.oze_app.service.ZasobnikCWUService;

import java.util.List;


@Controller
@RequestMapping("/api/zasobniki-cwu")
public class ZasobnikCWUController {

    private final ZasobnikCWUService zasobnikCWUService;

    @Autowired
    public ZasobnikCWUController(ZasobnikCWUService zasobnikCWUService) {
        this.zasobnikCWUService = zasobnikCWUService;
    }

    @GetMapping
    public List<ZasobnikCWU> getAllZasobnikiCWU() {
        return zasobnikCWUService.getAllZasobnikiCWU();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZasobnikCWU> getZasobnikCWUById(@PathVariable Long id) {
        ZasobnikCWU zasobnikCWU = zasobnikCWUService.getZasobnikCWUById(id);
        return zasobnikCWU != null ? ResponseEntity.ok(zasobnikCWU) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ZasobnikCWU> createZasobnikCWU(@Valid @RequestBody ZasobnikCWU zasobnikCWU) {
        ZasobnikCWU createdZasobnik = zasobnikCWUService.createZasobnikCWU(zasobnikCWU);
        return ResponseEntity.ok(createdZasobnik);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZasobnikCWU(@PathVariable Long id) {
        zasobnikCWUService.deleteZasobnikCWU(id);
        return ResponseEntity.noContent().build();
    }
}