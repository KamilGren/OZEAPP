package pl.gren.oze_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gren.oze_app.model.BuildingRequirements;
import pl.gren.oze_app.service.BuildingCalculatorService;
import pl.gren.oze_app.service.BuildingRequirementsService;

@Controller
public class BuildingRequirementsController {

    BuildingRequirementsService buildingRequirementsService;
    BuildingCalculatorService buildingCalculatorService;

    @Autowired
    public BuildingRequirementsController(BuildingRequirementsService buildingRequirementsService, BuildingCalculatorService buildingCalculatorService) {
        this.buildingRequirementsService = buildingRequirementsService;
        this.buildingCalculatorService = buildingCalculatorService;
    }

    @GetMapping("/math/{buildingRequirementsID}")
    public void lostMath(@PathVariable Long buildingRequirementsID) {
        BuildingRequirements buildingRequirements = buildingRequirementsService.getBuildingReqById(buildingRequirementsID);
        buildingCalculatorService.lost1(buildingRequirements.getId());
    }


    @GetMapping("/")
    public String showBuildingRequirementsForm(Model model) {
        // Tworzymy nowy obiekt BuildingRequirements, który będzie używany przez formularz
        BuildingRequirements buildingRequirements = new BuildingRequirements();

        // Przesyłamy pusty obiekt do widoku formularza
        model.addAttribute("buildingRequirements", buildingRequirements);

        // Zwracamy nazwę widoku formularza
        return "buildingRequirementsForm";
    }

    // Endpoint obsługujący żądania POST z formularza
    @PostMapping("/processBuildingRequirements")
    public String processBuildingRequirements(BuildingRequirements buildingRequirements, Model model) {

        // building calculator
        //buildingCalculatorService.lost1(buildingRequirements.getId());

        buildingRequirementsService.saveBuildingRequirements(buildingRequirements);


        // Przesyłamy dane do widoku wyniku
        model.addAttribute("buildingRequirements", buildingRequirements);

        // Zwracamy nazwę widoku wyniku
        return "buildingRequirementsResult";
    }
}
