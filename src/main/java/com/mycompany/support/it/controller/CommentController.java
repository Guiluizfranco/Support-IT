/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.CommentDTO;
import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guil_dev
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    
    private final CommentService service;
    
    public CommentController(CommentService service){
        this.service = service;
    }
    
    @PostMapping
    public ResponseDTO CreateComment(@RequestBody CommentDTO dto){
        
        return service.CreateComment(dto);
        
    }
    
}
