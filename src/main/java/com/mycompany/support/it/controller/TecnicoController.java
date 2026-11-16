/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.dto.TecnicoEntityDTO;
import com.mycompany.support.it.entity.TecnicoEntity;
import com.mycompany.support.it.service.TecnicoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guil_dev
 */
@RestController
@RequestMapping("/tecnico")
public class TecnicoController {
    
    private final TecnicoService service;
    
    public TecnicoController(TecnicoService service){
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<?> CreateTecnico(@Valid @RequestBody TecnicoEntityDTO dto){
        return ResponseEntity.ok( service.CreateTecnico(dto));
        
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> AlterSpeciality(
            @PathVariable int id,
            @Valid @RequestBody TecnicoEntityDTO dto){
        
        return ResponseEntity.ok(service.AlterSpeciality(id, dto));
 
    }
    
    @DeleteMapping("/{id}")
    public ResponseDTO DeleteTecnico(@PathVariable int id){
        
        return service.DeleteTecnico(id);
        
    }
    
    @PatchMapping("/status/{id}")
    public ResponseEntity<?> AlterStatusTecnico(
            @PathVariable int id,
            @Valid @RequestBody TecnicoEntityDTO dto){
        
        
        return ResponseEntity.ok(service.AlterStatusTecnico(id, dto));
        
    }
    
    @GetMapping
    public List<TecnicoEntity> SelectAllTecnico(){
        
        return service.SelectAllTecnico();
        
    }
    
    
}
