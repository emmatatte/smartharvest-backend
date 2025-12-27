package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.CompanyDTO;
import pe.edu.upc.smartharvest.dtos.LocalMarketDTO;
import pe.edu.upc.smartharvest.dtos.MaintenanceDTO;
import pe.edu.upc.smartharvest.entities.LocalMarket;
import pe.edu.upc.smartharvest.servicesinterfaces.IMarketPlaceService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/localmarkets")
@SecurityRequirement(name = "bearerAuth")
public class LocalMarketController {
    @Autowired
    private IMarketPlaceService mS;

    public LocalMarketController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR','DUEÑO_DE_MERCADO')")
    public List<LocalMarketDTO> listar() {
        return mS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, LocalMarketDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','DUEÑO_DE_MERCADO')")
    public void registrar(@RequestBody LocalMarketDTO mDTO) {
        ModelMapper m = new ModelMapper();
        LocalMarket ml = m.map(mDTO, LocalMarket.class);
        mS.insert(ml);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','DUEÑO_DE_MERCADO')")
    public void modificar(@RequestBody LocalMarketDTO mDTO) {
        ModelMapper m = new ModelMapper();
        LocalMarket ml = m.map(mDTO, LocalMarket.class);
        mS.update(ml);
    }

    @GetMapping("/{idLocalMarket}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DUEÑO_DE_MERCADO')")
    public LocalMarketDTO listarId(@PathVariable("idLocalMarket") int idLocalMarket) {
        ModelMapper m = new ModelMapper();
        LocalMarketDTO dto = m.map(mS.listId(idLocalMarket), LocalMarketDTO.class);
        return dto;
    }

    @DeleteMapping("/{idMercadoLocal}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DUEÑO_DE_MERCADO')")
    public void eliminar(@PathVariable("idMercadoLocal") int idMercadoLocal) {
        mS.delete(idMercadoLocal);
    }

    @GetMapping("/by-location")
    public List<LocalMarketDTO> getByLocation(@RequestParam("location") String location) {
        return mS.findByLocation(location).stream()
                .map(x -> new ModelMapper().map(x, LocalMarketDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/listarporiduser/{idUser}")
    @PreAuthorize("hasAuthority('DUEÑO_DE_MERCADO')")
    public List<LocalMarketDTO> listbyiduser(@PathVariable("idUser") Long idUser) {
        return mS.findLocalMarketsByUsers_Id(idUser).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, LocalMarketDTO.class);
        }).collect(Collectors.toList());
    }
}
