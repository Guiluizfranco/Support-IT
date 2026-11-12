/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 *
 * @author guil_dev
 */
public class TecnicoEntityDTO {
    
   
  
    @NotBlank(message = "É necessário inserir o nome")
    private String nome;
    
    @NotBlank(message = "É necessário inserir o email")
    @Email(message = "Email inválido")
    private String email;
   
    @NotBlank(message = "É necessário inserir a especialidade")
    private String especialidade;
        
    private String status;
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEspecialidade(){
        return especialidade;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
   
}
