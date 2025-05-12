package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.NotificacionDTO;
import pe.edu.upc.smartharvest.entities.Notificacion;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/notificaciones")

public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    public NotificacionController() {
    }

    @GetMapping
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(nDTO, Notificacion.class);
        nS.insert(n);
    }

    @PutMapping
    public void modificar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(nDTO, Notificacion.class);
        nS.update(n);
    }

    @DeleteMapping("/{idNotification}")
    public void eliminar(@PathVariable int idNotificacion) {
        nS.delete(idNotificacion);
    }
}
