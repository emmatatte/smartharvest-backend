package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.ShareActionDTO;
import pe.edu.upc.smartharvest.entities.ShareAction;
import pe.edu.upc.smartharvest.servicesinterfaces.IShareActionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shareactions")
public class ShareActionController {

    @Autowired
    private IShareActionService shareActionService;

    @PostMapping // US06 - El usuario puede compartir su experiencia con otros agricultores como recomendación.
    public void insert(@RequestBody ShareActionDTO dto) {
        ModelMapper m = new ModelMapper();
        ShareAction entity = m.map(dto, ShareAction.class);
        shareActionService.insert(entity);
    }

    @GetMapping("/by-content")  // US06 - El usuario puede consultar los contenidos compartidos con otros agricultores.
    public List<ShareActionDTO> getBySharedContent(@RequestParam("sharedContent") String sharedContent) {
        return shareActionService.findBySharedContent(sharedContent).stream()
                .map(x -> new ModelMapper().map(x, ShareActionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<ShareActionDTO> list() {
        return shareActionService.list().stream()
                .map(x -> new ModelMapper().map(x, ShareActionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShareActionDTO getById(@PathVariable("id") int id) {
        ShareAction action = shareActionService.listId(id);
        return new ModelMapper().map(action, ShareActionDTO.class);
    }

    @PutMapping
    public void update(@RequestBody ShareActionDTO dto) {
        ModelMapper m = new ModelMapper();
        ShareAction entity = m.map(dto, ShareAction.class);
        shareActionService.insert(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        shareActionService.delete(id);
    }
}
