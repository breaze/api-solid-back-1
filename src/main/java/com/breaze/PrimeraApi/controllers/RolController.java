package com.breaze.PrimeraApi.controllers;

import com.breaze.PrimeraApi.dtos.RolCreateRequest;
import com.breaze.PrimeraApi.dtos.RolReponse;
import com.breaze.PrimeraApi.dtos.RolUpdateRequest;
import com.breaze.PrimeraApi.entities.Rol;
import com.breaze.PrimeraApi.services.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {

    private final IRolService rolService;

    @GetMapping
    public ResponseEntity<List<RolReponse>> findAll(){
        List<RolReponse> response = rolService.findAll().stream()
                .map(this::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolReponse> findById(@PathVariable Long id){
        return rolService.findById(id)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RolReponse> save(@RequestBody RolCreateRequest request){
        Rol rol = new Rol();
        rol.setNombre(request.getNombre());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(rolService.save(rol)));
    }

    private RolReponse toResponse(Rol rol){
        RolReponse response = new RolReponse();
        response.setId(rol.getId());
        response.setNombre(rol.getNombre());
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return rolService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RolReponse> save(@RequestBody RolUpdateRequest request, @PathVariable Long id){
        Rol rol = new Rol();
        rol.setNombre(request.getNombre());

        return  rolService.update(id, rol)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
