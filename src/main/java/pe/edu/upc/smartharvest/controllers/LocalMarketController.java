package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.LocalMarketDTO;
import pe.edu.upc.smartharvest.entities.LocalMarket;
import pe.edu.upc.smartharvest.servicesinterfaces.IMarketPlaceService;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/localmarkets")
public class LocalMarketController {
    @Autowired
    private IMarketPlaceService mS;

    public LocalMarketController() {
    }

    @GetMapping
    public List<LocalMarketDTO> listar() {
        return mS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, LocalMarketDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody LocalMarketDTO mDTO) {
        ModelMapper m = new ModelMapper();
        LocalMarket ml = m.map(mDTO, LocalMarket.class);
        mS.insert(ml);
    }

    @PutMapping
    public void modificar(@RequestBody LocalMarketDTO mDTO) {
        ModelMapper m = new ModelMapper();
        LocalMarket ml = m.map(mDTO, LocalMarket.class);
        mS.update(ml);
    }

    @DeleteMapping("/{idMercadoLocal}")
    public void eliminar(@PathVariable("idMercadoLocal") int idMercadoLocal) {
        mS.delete(idMercadoLocal);
    }

    @GetMapping("/by-location") // US05 - El usuario puede buscar mercados locales cercanos por ubicación.
    public List<LocalMarketDTO> getByLocation(@RequestParam("location") String location) {
        return mS.findByLocation(location).stream()
                .map(x -> new ModelMapper().map(x, LocalMarketDTO.class))
                .collect(Collectors.toList());
    }

}
