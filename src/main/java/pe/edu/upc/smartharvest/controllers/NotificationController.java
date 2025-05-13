package pe.edu.upc.smartharvest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.NotificationDTO;
import pe.edu.upc.smartharvest.entities.Notification;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
@SecurityRequirement(name = "bearerAuth")
public class NotificationController {
    @Autowired
    private INotificationService nS;

    public NotificationController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public List<NotificationDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody NotificationDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notification n = m.map(nDTO, Notification.class);
        nS.insert(n);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificationDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notification n = m.map(nDTO, Notification.class);
        nS.update(n);
    }

    @DeleteMapping("/{idNotification}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable int idNotification) {
        nS.delete(idNotification);
    }

    @GetMapping("/by-type/{type}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<NotificationDTO> getByType(@PathVariable("type") String type) {
        return nS.findByNotificationType(type).stream()
                .map(x -> new ModelMapper().map(x, NotificationDTO.class))
                .collect(Collectors.toList());
    }

}
