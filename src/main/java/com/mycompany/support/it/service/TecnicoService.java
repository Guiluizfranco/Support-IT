/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.service;

import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.dto.TecnicoEntityDTO;
import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.entity.TecnicoEntity;
import com.mycompany.support.it.repository.CallRepository;
import com.mycompany.support.it.repository.TecnicoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author guil_dev
 */
@Service
public class TecnicoService {
    
    private final TecnicoRepository tecnicoRepository;
    private final CallRepository callRepository;
    
    ResponseDTO response = new ResponseDTO();
    
    public TecnicoService(TecnicoRepository tecnicoRepository, CallRepository callRepository){
        this.tecnicoRepository = tecnicoRepository;
        this.callRepository = callRepository;
    }
    
    public ResponseDTO CreateTecnico(TecnicoEntityDTO dto){
        
        TecnicoEntity tecnico = new TecnicoEntity();
        
        tecnico.setNome(dto.getNome()); 
        tecnico.setEmail(dto.getEmail());
        tecnico.setEspecialidade(dto.getEspecialidade());
        
        tecnicoRepository.save(tecnico);
        
        response.setMessage("Tecnico cadastrado com sucesso");
        
        return response;
    }
          
   public ResponseDTO AlterEspecialidade (int id, TecnicoEntityDTO dto){
       
       TecnicoEntity tecnico = tecnicoRepository.findById(id).get();
       
       tecnico.setEspecialidade(dto.getEspecialidade());
       
       tecnicoRepository.save(tecnico);
       
       response.setMessage("Especialidade alterada com sucesso");
       
       return response;
       
   }
   
   public ResponseDTO DeleteTecnico (int id){
       
       int i;
       
       TecnicoEntity tecnico = tecnicoRepository.findById(id).get();
       CallEntity chamado;
       List<CallEntity> listaChamado = callRepository.findAllByTecnico(tecnico);
       
       if(listaChamado.isEmpty()){
           
           tecnicoRepository.deleteById(id);
           
       }else{
           
           for(i = 0; i < listaChamado.size(); i++){
           
           chamado = listaChamado.get(i);
           chamado.setTecnicoEntity(null);
           
             }
           
           tecnicoRepository.deleteById(id);

       }
       
       response.setMessage("Tecnico excluído com sucesso");
       return response;
       
   }
    
}
