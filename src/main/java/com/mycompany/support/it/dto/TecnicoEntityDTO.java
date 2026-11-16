/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;



/**
 *
 * @author guil_dev
 */
public class TecnicoEntityDTO {
    
   
  
    @NotBlank(message = "É necessário inserir o nome")
    private JsonNullable<String> nome = JsonNullable.undefined();
    
    @NotBlank(message = "É necessário inserir o email")
    @Email(message = "Email inválido")
    private JsonNullable<String> email = JsonNullable.undefined();
   
    @NotBlank(message = "É necessário inserir a especialidade")
    private JsonNullable<String> especialidade = JsonNullable.undefined();
        
    private String status;
    
    public JsonNullable<String> getNome(){
        return nome;
    }
    public void setNome(JsonNullable<String> nome){
        this.nome = nome;
    }
    
    public JsonNullable<String> getEmail(){
        return email;
    }
    public void setEmail(JsonNullable<String> email){
        this.email = email;
    }
    
    public JsonNullable<String> getEspecialidade(){
        return especialidade;
    }
    public void setEspecialidade(JsonNullable<String> especialidade){
        this.especialidade = especialidade;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
   
}
