/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.service;

import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.dto.UserEntityDTO;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author guil_dev
 */
@Service
public class UserService {
    
    private final UserRepository userRepostiory;
    ResponseDTO response = new ResponseDTO();
    
    public UserService(UserRepository userRepostiory){
        this.userRepostiory = userRepostiory;
    }
    
    BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder (16);
    
    public ResponseDTO CreateUser(UserEntityDTO dto){

        UserEntity user = new UserEntity();
        
        user.setNome(dto.getNome().get());
        user.setUsuario(dto.getUsuario().get());
        user.setEmail(dto.getEmail().get());
        
        String senha = encoder.encode(dto.getSenha().get());
        user.setSenha(senha);
        
        user.setDepartamento(dto.getDepartamento().get());
        
        userRepostiory.save(user);
        
        response.setMessage("Usuário cadastrado com sucesso");
        
        return response;
        
    }
    
    public UserEntityDTO FindUserById(Integer id){
         
         UserEntity user = userRepostiory.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
         UserEntityDTO dto = new UserEntityDTO();
         
         dto.setNome(JsonNullable.of(user.getNome()));
         dto.setUsuario(JsonNullable.of(user.getUsuario()));
         dto.setEmail(JsonNullable.of(user.getEmail()));
         dto.setDepartamento(JsonNullable.of(user.getDepartamento()));
         
         return dto;
        
    }
    
    public UserEntityDTO FindUserByUsuario(String userName){
        
        UserEntity user = userRepostiory.findByUsuario(userName).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        UserEntityDTO dto = new UserEntityDTO();
        
         dto.setNome(JsonNullable.of(user.getNome()));
         dto.setUsuario(JsonNullable.of(user.getUsuario()));
         dto.setEmail(JsonNullable.of(user.getEmail()));
         dto.setDepartamento(JsonNullable.of(user.getDepartamento()));
         
         return dto;
    }
    
    public List<UserEntity> FindAllUsers(){
        
        return userRepostiory.findAll();
        
    }
    
    @Transactional
    public ResponseDTO UpdateUserById(Integer id, UserEntityDTO dto){
  
            UserEntity user = userRepostiory.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado")); 
            
            dto.getNome().ifPresent(user::setNome);
            dto.getUsuario().ifPresent(user::setUsuario);
            dto.getEmail().ifPresent(user::setEmail);
            dto.getSenha().ifPresent(user::setSenha);
            dto.getDepartamento().ifPresent(user::setDepartamento);
            
            userRepostiory.save(user);
            
            response.setMessage("Usuário atualizado com sucesso!");

            return response;
    } 
    
    @Transactional
    public ResponseDTO UpdateUserByUsuario(String userName, UserEntityDTO dto){

            UserEntity user = userRepostiory.findByUsuario(userName).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
            
            
            dto.getNome().ifPresent(user::setNome);
            dto.getUsuario().ifPresent(user::setUsuario);
            dto.getEmail().ifPresent(user::setEmail);
            dto.getSenha().ifPresent(user::setSenha);
            dto.getDepartamento().ifPresent(user::setDepartamento);
            
            userRepostiory.save(user);
            
            response.setMessage("Usuário atualizado");
 
           return response;
        
    }
    
    public ResponseDTO DeleteUserById(Integer id){
        
        userRepostiory.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado")); 
            
            
        userRepostiory.deleteById(id);
            
        response.setMessage("Usuário deletado com sucesso");
  
        return response;
        
    }
    
}
