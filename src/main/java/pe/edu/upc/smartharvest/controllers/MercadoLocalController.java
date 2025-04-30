package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.MercadoLocalDTO;
import pe.edu.upc.smartharvest.entities.MercadoLocal;
import pe.edu.upc.smartharvest.servicesinterfaces.IMercadoLocalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mercadoLocal")
public class MercadoLocalController {
    @Autowired
    private IMercadoLocalService mS;

    public MercadoLocalController() {
    }

    @GetMapping
    public List<MercadoLocalDTO> listar() {
        return mS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, MercadoLocalDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody MercadoLocalDTO mDTO) {
        ModelMapper m = new ModelMapper();
        MercadoLocal ml = m.map(mDTO, MercadoLocal.class);
        mS.insert(ml);
    }

    @PutMapping
    public void modificar(@RequestBody MercadoLocalDTO mDTO) {
        ModelMapper m = new ModelMapper();
        MercadoLocal ml = m.map(mDTO, MercadoLocal.class);
        mS.update(ml);
    }

    @DeleteMapping("/{idMercadoLocal}")
    public void eliminar(@PathVariable("idMercadoLocal") int idMercadoLocal) {
        mS.delete(idMercadoLocal);
    }
}
