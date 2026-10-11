/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.dto.TecnicoEntityDTO;
import com.mycompany.support.it.service.TecnicoService;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseDTO CreateTecnico(@RequestBody TecnicoEntityDTO dto){
        return service.CreateTecnico(dto);
        
    }
    
    @PatchMapping("/{id}")
    public ResponseDTO AlterEspecialidade(
            @PathVariable int id,
            @RequestBody TecnicoEntityDTO dto){
        
        return service.AlterEspecialidade(id, dto);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseDTO DeleteTecnico(@PathVariable int id){
        
        return service.DeleteTecnico(id);
        
    }
    
    
    
}
