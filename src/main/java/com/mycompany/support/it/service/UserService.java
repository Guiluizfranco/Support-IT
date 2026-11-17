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
    
    public ResponseDTO CreateUser(UserEntityDTO dto){
        
        UserEntity user = new UserEntity();
        
        user.setNome(dto.getNome());
        user.setUsuario(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        user.setDepartamento(dto.getDepartamento());
        
        userRepostiory.save(user);
        
        response.setMessage("Usuário cadastrado com sucesso");
        
        return response;
        
    }
    
    public UserEntity FindUserById(Integer id){
        
        return userRepostiory.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        
    }
    
    public UserEntity FindUserByUsuario(String usuario){
        
        return userRepostiory.findByUsuario(usuario).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        
    }
    
    public List<UserEntity> FindAllUsers(){
        
        return userRepostiory.findAll();
        
    }
    
    @Transactional
    public ResponseDTO UpdateUserById(Integer id, UserEntityDTO dto){
        
           userRepostiory.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado")); 
            
            UserEntity user = new UserEntity();
            
            user.setId(id);
            user.setNome(dto.getNome());
            user.setUsuario(dto.getUsuario());
            user.setEmail(dto.getEmail());
            user.setSenha(dto.getSenha());
            user.setDepartamento(dto.getDepartamento());
            
            userRepostiory.save(user);
            
            response.setMessage("Usuário atualizado com sucesso!");

            return response;
    } 
    
    @Transactional
    public ResponseDTO UpdateUserByUsuario(String usuario, UserEntityDTO dto){
        
           userRepostiory.findByUsuario(usuario).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
  
            UserEntity user = new UserEntity();
            
            user.setId(FindUserByUsuario(usuario).getId());
            user.setNome(dto.getNome());
            user.setUsuario(dto.getUsuario());
            user.setEmail(dto.getEmail());
            user.setSenha(dto.getSenha());
            user.setDepartamento(dto.getDepartamento());
            
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
