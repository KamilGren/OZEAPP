package pl.gren.oze_app.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.oze_app.model.Inwerter;
import pl.gren.oze_app.service.InwerterService;

import java.util.List;

@RestController
@RequestMapping("/api/inwertery")
public class InwerterController {

    private final InwerterService inwerterService;

    @Autowired
    public InwerterController(InwerterService inwerterService) {
        this.inwerterService = inwerterService;
    }

    @GetMapping("/all")
    public List<Inwerter> getAllInwertery() {
        return inwerterService.getAllInwertery();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inwerter> getInwerterById(@PathVariable Long id) {
        Inwerter inwerter = inwerterService.getInwerterById(id);
        return inwerter != null ? ResponseEntity.ok(inwerter) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public Inwerter addInwerter(@Valid @RequestBody Inwerter inwerter) {
        return inwerterService.saveInwerter(inwerter);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInwerter(@PathVariable Long id) {
        inwerterService.deleteInwerter(id);
    }
}
