package laboratory_tracking.Service;

import jakarta.persistence.EntityNotFoundException;
import laboratory_tracking.Model.Laboratory;
import laboratory_tracking.Repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<String> getAllLaboratories() {
        List<Laboratory> laboratories = new ArrayList<>();
        laboratoryRepository.findAll().forEach(laboratories::add);
        List<String> laboratoriesString = new ArrayList<>();
        for (Laboratory laboratory : laboratories) {
            laboratoriesString.add(laboratory.toString());
        }
        return laboratoriesString;
    }

    public String getLaboratoryStr(int id) {
        Laboratory laboratory = laboratoryRepository.findById(id).orElse(null);
        if (laboratory == null) {
            return "Laboratory with id " + id + " not found";
        }
        return laboratory.toString();
    }

    public Laboratory getLaboratory(int id) {
        Laboratory laboratory = laboratoryRepository.findById(id).orElse(null);
        if (laboratory == null) {
            throw new EntityNotFoundException("Laboratory with id " + id + " not found");
        }
        return laboratory;
    }

    public void addLaboratory(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public void updateLaboratory(int id, Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public void deleteLaboratory(int id) {
        laboratoryRepository.deleteById(id);
    }
}
