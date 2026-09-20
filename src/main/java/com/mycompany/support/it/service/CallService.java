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
import java.util.ArrayList;
import java.util.List;
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
    
    public CallResponseDTO AlterStatusCall(CallEntityDTO dto, int id){
        
        CallEntity call = callRepository.findById(id).get();
        
        call.setStatus(dto.getStatus());
        
        callRepository.save(call);
        
        response.setMessage("Status alterado com sucesso! O chamado está " + dto.getStatus());
        
        return response;
        
    }
    
    public List<CallEntity> GetAllCall(){
        
        return callRepository.findAll();
  
    }
    
    public List<CallEntity> GetAllUserCalls(Integer id){
        
        UserEntity user = userRepository.findById(id).get();
        
        return callRepository.findAllByUser(user);
        
    }
    
    public List<CallEntity> GetAllStatusCalls(String status){
        
        return callRepository.findAllByStatus(status);
        
    }
}
