package pl.gren.oze_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gren.oze_app.model.Inwerter;
import pl.gren.oze_app.repository.InwerterRepository;

import java.util.List;

@Service
public class InwerterService {

    private final InwerterRepository inwerterRepository;

    @Autowired
    public InwerterService(InwerterRepository inwerterRepository) {
        this.inwerterRepository = inwerterRepository;
    }

    public List<Inwerter> getAllInwertery() {
        return inwerterRepository.findAll();
    }

    public Inwerter getInwerterById(Long id) {
        return inwerterRepository.findById(id).orElse(null);
    }

    public Inwerter saveInwerter(Inwerter inwerter) {
        return inwerterRepository.save(inwerter);
    }

    public void deleteInwerter(Long id) {
        inwerterRepository.deleteById(id);
    }
}
