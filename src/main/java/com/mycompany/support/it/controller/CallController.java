/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.CallEntityDTO;
import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.service.CallService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guil_dev
 */
@RestController
@RequestMapping("/call")
public class CallController {
    
    private final CallService service;
    
    public CallController(CallService service){
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<?> CreateCall(@Valid @RequestBody CallEntityDTO dto){
        return ResponseEntity.ok(service.CreateCall(dto));
    }
    
    @PatchMapping("/status/{id}")
    public ResponseDTO AlterStatusCall(
            @PathVariable int id,
            @RequestBody CallEntityDTO dto){
        
        return service.AlterStatusCall(dto, id);
        
    }
    
    @PatchMapping("/tecnico/{id}")
    public ResponseDTO AlterTecnicoAssociateCall(
            @PathVariable int id,
            @RequestBody CallEntityDTO dto){
        
        return service.AlterTecnicoAssociateCall(dto, id);
        
    }
    
    
    @GetMapping
    public Page<CallEntity> GetAllCalls(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        
        return service.GetAllCall(page, size);
    }
    
    @GetMapping("/{id}")
    public Page<CallEntity> GetAllUserCalls(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        
        return service.GetAllUserCalls(id, page, size);
    }
    
    @GetMapping("/search")
    public Page<CallEntity> GetAllStatusCalls(
            @RequestParam String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        
        return service.GetAllStatusCalls(status, page, size);
    }
}
