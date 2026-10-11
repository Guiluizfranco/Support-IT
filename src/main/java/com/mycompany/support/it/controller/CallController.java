/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.CallEntityDTO;
import com.mycompany.support.it.dto.CallResponseDTO;
import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.service.CallService;
import java.util.List;
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
    public CallResponseDTO CreateCall(@RequestBody CallEntityDTO dto){
        return service.CreateCall(dto);
    }
    
    @PatchMapping("/status/{id}")
    public CallResponseDTO AlterStatusCall(
            @PathVariable int id,
            @RequestBody CallEntityDTO dto){
        
        return service.AlterStatusCall(dto, id);
        
    }
    
    @PatchMapping("/tecnico/{id}")
    public CallResponseDTO AlterTecnicoAssociateCall(
            @PathVariable int id,
            @RequestBody CallEntityDTO dto){
        
        return service.AlterTecnicoAssociateCall(dto, id);
        
    }
    
    
    @GetMapping
    public List<CallEntity> GetAllCalls(){
        return service.GetAllCall();
    }
    
    @GetMapping("/{id}")
    public List<CallEntity> GetAllUserCalls(@PathVariable Integer id){
        return service.GetAllUserCalls(id);
    }
    
    @GetMapping("/search")
    public List<CallEntity> GetAllStatusCalls(@RequestParam String status){
        return service.GetAllStatusCalls(status);
    }
}
