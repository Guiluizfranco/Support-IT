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
import java.util.NoSuchElementException;
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
        
        tecnico.setNome(dto.getNome().get()); 
        tecnico.setEmail(dto.getEmail().get());
        tecnico.setEspecialidade(dto.getEspecialidade().get());
        tecnico.setAtivo(true);
        
        tecnicoRepository.save(tecnico);
        
        response.setMessage("Tecnico cadastrado com sucesso");
        
        return response;
    }
          
   public ResponseDTO AlterSpeciality (int id, TecnicoEntityDTO dto){
       
       TecnicoEntity tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Técnico informado não existe"));
       
       if(tecnico.getAtivo()){
           if(dto.getEspecialidade().isPresent()){
               
               String novaEspecialidade = dto.getEspecialidade().get();
               
               if(novaEspecialidade.equals(tecnico.getEspecialidade()) && novaEspecialidade != null){
                   response.setMessage("Especialidade já atribuída ao técnico");
                   return response;
                   
               }
               
               dto.getNome().ifPresent(tecnico::setNome);
               dto.getEmail().ifPresent(tecnico::setEmail);
               dto.getEspecialidade().ifPresent(tecnico::setEspecialidade);
               tecnicoRepository.save(tecnico);
               response.setMessage("Técnico alterado com sucesso");
           }
             
       }else{
           
         response.setMessage("Técnico se encontra inativo");
           
       }
 
       return response;
       
   }
   
   public ResponseDTO DeleteTecnico (int id){
       
       int i;
       
       TecnicoEntity tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Técnico informado não existe"));
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
   
   public ResponseDTO AlterStatusTecnico(int id, TecnicoEntityDTO dto){
       
       TecnicoEntity tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Técnico informado não existe"));
       
       dto.getNome().ifPresent(tecnico::setNome);
       dto.getEmail().ifPresent(tecnico::setEmail);
       dto.getEspecialidade().ifPresent(tecnico::setEspecialidade);
       
        switch(dto.getStatus().toLowerCase()){
           
           case "ativo":
               
               if(tecnico.getAtivo()){
                   
                   response.setMessage("Técnico já se encontra ativo");
                   
               }else{

                   tecnico.setAtivo(!tecnico.getAtivo());
                   
                   tecnicoRepository.save(tecnico);
                   
                   response.setMessage("Status alterado com sucesso!");
                   
               }
               break;
               
           case "inativo":      
               
               if(tecnico.getAtivo()){

                   tecnico.setAtivo(!tecnico.getAtivo());
                   
                   tecnicoRepository.save(tecnico);
                   
                   response.setMessage("Status alterado com sucesso!");
  
               }else{
                   response.setMessage("Técnico já se encontra inativo");
 
               }
               break;
               
           default:
               
               response.setMessage("Não foi possivel alterar o status. Insira um valor válido (Ativo / Inativo)");
               
       }
               
       return response;
       
       
   }
   
   public List SelectAllTecnico(){       
       
       return tecnicoRepository.findAll();
       
   }
    
}
