/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.UserEntityDTO;
import com.mycompany.support.it.dto.UserResponseDTO;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("user")
public class UserController {
    
    private final UserService service;
    
    public UserController(UserService service){
        this.service = service;
    }
   
   @PostMapping 
   public UserResponseDTO CreateUser(@RequestBody UserEntityDTO dto){
       return service.CreateUser(dto);
   }
   
   @GetMapping("/{id}")
   public UserEntity FindUserById(@PathVariable Integer id){
       return service.FindUserById(id);
   }
   
   @GetMapping("/search")
   public UserEntity FindUserByUsuario(
           @RequestParam(required=false) String usuario){
       
       return service.FindUserByUsuario(usuario);
       
   }
   
}
