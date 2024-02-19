package pl.gren.oze_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gren.oze_app.model.ZasobnikCO;
import pl.gren.oze_app.service.ZasobnikCOService;

import java.util.List;

@Controller
@RequestMapping("/api/zasobniki-co")
public class ZasobnikCOController {

    private ZasobnikCOService zasobnikCOService;

    @Autowired
    public ZasobnikCOController(ZasobnikCOService zasobnikCOService) {
        this.zasobnikCOService = zasobnikCOService;
    }

    @GetMapping("/all")
    public List<ZasobnikCO> getAllZasobnikiCO() {
        return zasobnikCOService.getAllZasobnikiCO();
    }

    @GetMapping("/{id}")
    public ZasobnikCO getZasobnikCOById(@PathVariable Long id) {
        return zasobnikCOService.getZasobnikCOById(id);
    }

    @PostMapping("/add")
    public ZasobnikCO addZasobnikCO(@RequestBody ZasobnikCO zasobnikCO) {
        return zasobnikCOService.saveZasobnikCO(zasobnikCO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteZasobnikCO(@PathVariable Long id) {
        zasobnikCOService.deleteZasobnikCO(id);
    }
}