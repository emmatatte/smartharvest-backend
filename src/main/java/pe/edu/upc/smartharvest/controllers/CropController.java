package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.*;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.servicesinterfaces.ICropService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/crops")
@SecurityRequirement(name = "bearerAuth")
public class CropController {
    @Autowired
    private ICropService cS;

    public CropController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<CropDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CropDTO.class);

        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void registrar(@RequestBody CropDTOforRegister cDTO) {
        ModelMapper m = new ModelMapper();
        Crop c = m.map(cDTO, Crop.class);
        cS.insert(c);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody CropDTOforRegister cDTO) {
        ModelMapper m = new ModelMapper();
        Crop c = m.map(cDTO, Crop.class);
        cS.update(c);
    }

    @GetMapping("/{idCrop}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public CropDTO listarId(@PathVariable("idCrop") int idCrop) {
        ModelMapper m = new ModelMapper();
        CropDTO dto = m.map(cS.listId(idCrop), CropDTO.class);
        return dto;
    }

    @DeleteMapping("/{idCultivo}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idCultivo) {
        cS.delete(idCultivo);
    }

    @GetMapping("/by-type/{typeCrop}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<CropDTO> getByType(@PathVariable("typeCrop") String typeCrop) {
        return cS.findByTypeCrop(typeCrop).stream()
                .map(x -> new ModelMapper().map(x, CropDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-state/{actualState}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<CropDTO> getByState(@PathVariable("actualState") String actualState) {
        return cS.findByActualState(actualState).stream()
                .map(x -> new ModelMapper().map(x, CropDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/cropsInDanger")
    @PreAuthorize("hasAnyAuthority('AGRICULTOR','ADMIN')")
    public List<CropsNeedingAttentionDTO> cultivosNecesitanAtencion(){
    List<String[]> filaLista = cS.findCropsNeedingAttention();
    List<CropsNeedingAttentionDTO> dtoLista = new ArrayList<>();
    for (String[] columna : filaLista) {
        CropsNeedingAttentionDTO dto = new CropsNeedingAttentionDTO();
        dto.setIdCrop(Integer.parseInt(columna[0]));
        dto.setTypeCrop(columna[1]);
        dto.setName(columna[2]);
        dto.setActualState(columna[3]);
        LocalDate sowingDate = LocalDate.parse(columna[4]);
        dto.setSowingDate(sowingDate);
        dtoLista.add(dto);
    }
    return dtoLista;
    }

    @GetMapping("/findActiveCrop")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<FindActiveCropsDTO> findActiveCrops(){
        List<String[]> filaLista = cS.findActiveCrops();
        List<FindActiveCropsDTO> dtoLista = new ArrayList<>();
        for(String[] columna : filaLista){
            FindActiveCropsDTO dto = new FindActiveCropsDTO();
            dto.setIdCrop(Integer.parseInt(columna[0]));
            dto.setActualState(columna[1]);
            dto.setName(columna[2]);
            dto.setType_crop(columna[3]);
            dto.setSowing_date(LocalDate.parse(columna[4]));
            dto.setIdParcel(Integer.parseInt(columna[5
                    ]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
