package pe.edu.upc.smartharvest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.smartharvest.dtos.*;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@RequestMapping("/parcels")
@SecurityRequirement(name = "bearerAuth")
public class ParcelController {
    @Autowired
    private IParcelService pS;

    public ParcelController() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<ParcelDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ParcelDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void registrar(@RequestBody ParcelDTOforRegister pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.insert(p);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void modificar(@RequestBody ParcelDTOforRegister pDTO) {
        ModelMapper m = new ModelMapper();
        Parcel p = m.map(pDTO, Parcel.class);
        pS.update(p);
    }

    @DeleteMapping("/{idParcela}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public void eliminar(@PathVariable int idParcela) {
        pS.delete(idParcela);
    }

    @GetMapping("/by-user/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<ParcelDTO> getParcelsByUser(@PathVariable("userId") Long userId) {
        return pS.findByUserId(userId).stream()
                .map(x -> new ModelMapper().map(x, ParcelDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{idParcela}")
    public ParcelDTO listarId(@PathVariable("idParcela") int idParcela) {
        ModelMapper m = new ModelMapper();
        ParcelDTO dto = m.map(pS.listId(idParcela), ParcelDTO.class);
        return dto;
    }

    @GetMapping("/findactiveparcels")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<FindActiveParcelsDTO> findActiveParcels(){
        List<FindActiveParcelsDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=pS.findActiveParcels();
        for(String[] column:RowList){
            FindActiveParcelsDTO dto = new FindActiveParcelsDTO();
            dto.setIdParcel(Integer.parseInt(column[0]));
            dto.setName(column[1]);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/parcelsbymonth/{year}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AGRICULTOR')")
    public List<ParcelsByMonthDTO> parcelsByMonth(@PathVariable("year") int year){
        List<ParcelsByMonthDTO> dtoList = new ArrayList<>();
        List<String[]> RowList=pS.countParcelsByMonthInYear(year);
        for(String[] column:RowList){
            ParcelsByMonthDTO dto = new ParcelsByMonthDTO();
            dto.setMes(column[0]);
            dto.setCantidad(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/listarporiduser/{idUser}")
    @PreAuthorize("hasAuthority('AGRICULTOR')")
    public List<ParcelDTO> listbyiduser(@PathVariable("idUser") Long idUser) {
        return pS.findByUserId(idUser).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ParcelDTO.class);
        }).collect(Collectors.toList());
    }
}
