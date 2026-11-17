/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.controller;

import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.dto.UserEntityDTO;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
   public ResponseEntity<?> CreateUser(@Valid @RequestBody UserEntityDTO dto){
       
       return ResponseEntity.ok(service.CreateUser(dto));
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
   
   @GetMapping
   public List<UserEntity> FindAllUsers(){
       
       return service.FindAllUsers();
       
   }
   
   @PatchMapping("/{id}")
   public ResponseDTO UpdateUserById(
           @RequestBody UserEntityDTO dto,
           @PathVariable Integer id){
       
       return service.UpdateUserById(id, dto);
       
   }
   
   @PatchMapping("/update")
   public ResponseDTO UpdateUserByUsuario(
           @RequestParam String usuario,
           @RequestBody UserEntityDTO dto){
       
      return service.UpdateUserByUsuario(usuario, dto);
       
   }
   
   @DeleteMapping("/{id}")
   public ResponseDTO DeleteUserById(@PathVariable Integer id){
       
       return service.DeleteUserById(id);
       
   }
   
}
