package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.repositories.IInputRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IInputService;

import java.util.List;

@Service
public class InputServiceImplement implements IInputService {
    @Autowired
    private IInputRepository iR;

    @Override
    public List<Input> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Input input) {
        iR.save(input);
    }

    @Override
    public void update(Input input) {
        iR.save(input);
    }

    @Override
    public void delete(int idInsumo) {
        iR.deleteById(idInsumo);
    }

    @Override
    public Input listId(int idInput) {
        return iR.findById(idInput).orElse(new Input());
    }
}
