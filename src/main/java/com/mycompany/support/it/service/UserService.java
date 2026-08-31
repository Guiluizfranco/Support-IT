/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.service;

import com.mycompany.support.it.dto.UserEntityDTO;
import com.mycompany.support.it.dto.UserResponseDTO;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author guil_dev
 */
@Service
public class UserService {
    
    private final UserRepository repository;
    UserResponseDTO response = new UserResponseDTO();
    
    public UserService(UserRepository repostiory){
        this.repository = repostiory;
    }
    
    public UserResponseDTO CreateUser(UserEntityDTO dto){
        
        UserEntity user = new UserEntity();
        
        user.setNome(dto.getNome());
        user.setUsuario(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        user.setDepartamento(dto.getDepartamento());
        
        repository.save(user);
        
        response.setMessage("Usuário cadastrado com sucesso");
        
        return response;
        
    }
    
    public UserEntity FindUserById(Integer id){
        
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
    }
    
    public UserEntity FindUserByUsuario(String usuario){
        
        return repository.findByUsuario(usuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
    }
    
}
