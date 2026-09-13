/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.CallEntityDTO;
import com.mycompany.support.it.dto.CallResponseDTO;
import com.mycompany.support.it.service.CallService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
