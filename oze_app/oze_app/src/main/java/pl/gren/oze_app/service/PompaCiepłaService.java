package pl.gren.oze_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gren.oze_app.model.PompaCiepła;
import pl.gren.oze_app.repository.PompaCiepłaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PompaCiepłaService {

    private final PompaCiepłaRepository pompaCiepłaRepository;

    @Autowired
    public PompaCiepłaService(PompaCiepłaRepository pompaCiepłaRepository) {
        this.pompaCiepłaRepository = pompaCiepłaRepository;
    }

    public List<PompaCiepła> getAllPompy() {
        return pompaCiepłaRepository.findAll();
    }

    public Optional<PompaCiepła> getPompaById(Long id) {
        return pompaCiepłaRepository.findById(id);
    }

    public PompaCiepła savePompa(PompaCiepła pompaCiepła) {
        return pompaCiepłaRepository.save(pompaCiepła);
    }

    public void deletePompa(Long id) {
        pompaCiepłaRepository.deleteById(id);
    }
}