package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Input;

import java.util.List;

public interface IInputService {
    List<Input> list();
    void insert(Input input);
    void update(Input input);
    void delete(int idInput);
}
