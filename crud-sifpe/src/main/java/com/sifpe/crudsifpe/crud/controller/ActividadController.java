package com.sifpe.crudsifpe.crud.controller;

import com.sifpe.crudsifpe.crud.dto.ActividadDto;
import com.sifpe.crudsifpe.crud.entity.Actividad;
import com.sifpe.crudsifpe.crud.service.ActividadService;
import com.sifpe.crudsifpe.global.dto.MessageDto;
import com.sifpe.crudsifpe.global.exepctions.AttributeException;
import com.sifpe.crudsifpe.global.exepctions.ResourseNotFundException;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<Actividad>> getAll(){
        return ResponseEntity.ok(actividadService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Actividad> getOne(@PathVariable("id") int id) throws ResourseNotFundException {
        return ResponseEntity.ok(actividadService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody ActividadDto dto) throws AttributeException {
        Actividad actividad = actividadService.save(dto);
        String message = "actividad "+ actividad.getNombre()+ " han sido guardados";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable ("id") int id,@Valid @RequestBody ActividadDto dto) throws ResourseNotFundException, AttributeException {
        Actividad actividad = actividadService.update(id,dto);
        String message = "actividad "+ actividad.getNombre()+ " han sido actualizados";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <MessageDto> delete(@PathVariable("id") int id) throws ResourseNotFundException {
        Actividad actividad = actividadService.delete(id);
        String message = "actividad "+ actividad.getNombre()+ " han sido eliminados";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
