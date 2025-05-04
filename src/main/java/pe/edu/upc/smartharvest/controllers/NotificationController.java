package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.NotificationDTO;
import pe.edu.upc.smartharvest.entities.Notification;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificationService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private INotificationService nS;

    public NotificationController() {
    }

    @GetMapping
    public List<NotificationDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificationDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notification n = m.map(nDTO, Notification.class);
        nS.insert(n);
    }

    @PutMapping
    public void modificar(@RequestBody NotificationDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notification n = m.map(nDTO, Notification.class);
        nS.update(n);
    }

    @DeleteMapping("/{idNotification}")
    public void eliminar(@PathVariable int idNotification) {
        nS.delete(idNotification);
    }

    @GetMapping("/by-type/{type}")
    public List<NotificationDTO> getByType(@PathVariable("type") String type) {
        return nS.findByNotificationType(type).stream()
                .map(x -> new ModelMapper().map(x, NotificationDTO.class))
                .collect(Collectors.toList());
    }

}
