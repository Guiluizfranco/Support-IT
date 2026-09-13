/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.service;

import com.mycompany.support.it.dto.CallEntityDTO;
import com.mycompany.support.it.dto.CallResponseDTO;
import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.repository.CallRepository;
import com.mycompany.support.it.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author guil_dev
 */
@Service
public class CallService {
    
    private final CallRepository callRepository;
    private final UserRepository userRepository;
    
    CallResponseDTO response = new CallResponseDTO();
    
    public CallService(CallRepository callRepository, UserRepository userRepository){
        this.callRepository = callRepository;
        this.userRepository = userRepository;
    }
    
    public CallResponseDTO CreateCall(CallEntityDTO dto){
        
        UserEntity user = userRepository.findById(dto.getId()).get();
        CallEntity call = new CallEntity();
        
        call.setTitulo(dto.getTitulo());
        call.setDescricao(dto.getDescricao());
        call.setStatus(dto.getStatus());
        call.setDataAbertura(dto.getDataAbertura());
        call.setDataFechamento(dto.getDataFechamento());
        call.setUserEntity(user);
        
        callRepository.save(call);
        
        response.setMessage("Chamado cadastrado com sucesso");
        
        return response;
        
    }
    
}
