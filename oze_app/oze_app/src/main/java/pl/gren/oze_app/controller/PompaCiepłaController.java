package pl.gren.oze_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gren.oze_app.exceptions.BuildingRequirementsNotFoundException;
import pl.gren.oze_app.model.PompaCiepła;
import pl.gren.oze_app.service.PompaCiepłaService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/api/pompy")
public class PompaCiepłaController {

    private final PompaCiepłaService pompaCiepłaService;

    @Autowired
    public PompaCiepłaController(PompaCiepłaService pompaCiepłaService) {
        this.pompaCiepłaService = pompaCiepłaService;
    }

    @GetMapping
    public List<PompaCiepła> getAllPompy() {
        return pompaCiepłaService.getAllPompy();
    }

    @GetMapping("/parametryPompyCiepła/{id}")
    public String pokażParametryPompyCiepła(@PathVariable Long id, Model model) {
        PompaCiepła pompa = pompaCiepłaService.getPompaById(id).orElseThrow(() -> new NoSuchElementException("Brak tej pompy!"));
        model.addAttribute("pompa", pompa); // Dodaj obiekt do Model
        return "parametryPompyCiepla"; // Wyświetl widok
    }

    @GetMapping("/{id}")
    public ResponseEntity<PompaCiepła> getPompaById(@PathVariable Long id) {
        Optional<PompaCiepła> pompaCiepła = pompaCiepłaService.getPompaById(id);
        return pompaCiepła.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PompaCiepła> savePompa(@Valid @RequestBody PompaCiepła pompaCiepła) {
        PompaCiepła savedPompa = pompaCiepłaService.savePompa(pompaCiepła);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPompa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePompa(@PathVariable Long id) {
        pompaCiepłaService.deletePompa(id);
        return ResponseEntity.noContent().build();
    }
}