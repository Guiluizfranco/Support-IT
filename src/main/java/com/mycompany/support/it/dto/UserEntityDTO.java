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
public class UserEntityDTO {
    
    @NotBlank(message = "É necessário inserir o nome.")
    protected JsonNullable<String> nome = JsonNullable.undefined();
    
    @NotBlank(message = "É necessário inserir o usuario.")
    protected JsonNullable<String> usuario = JsonNullable.undefined();;
    
    @NotBlank(message = "É necessário inserir o email.")
    @Email
    protected JsonNullable<String> email = JsonNullable.undefined();;
    
    @NotBlank(message = "É necessário inserir a senha.")
    protected JsonNullable<String> senha = JsonNullable.undefined();;
    
    @NotBlank(message = "É necessário inserir o departamento.")
    protected JsonNullable<String> departamento = JsonNullable.undefined();;
    
     public JsonNullable<String> getNome(){
        return nome;
    }
    public void setNome(JsonNullable<String> nome){
        this.nome = nome;
    }
    
    public JsonNullable<String> getUsuario(){
        return usuario;
    }
    public void setUsuario(JsonNullable<String> usuario){
        this.usuario = usuario;
    }
    
    public JsonNullable<String> getEmail(){
        return email;
    }
    public void setEmail(JsonNullable<String> email){
        this.email = email;
    }
    
    public JsonNullable<String> getSenha(){
        return senha;
    }
    public void setSenha(JsonNullable<String> senha){
        this.senha = senha;
    }
    
    public JsonNullable<String> getDepartamento(){
        return departamento;
    }
    public void setDepartamento(JsonNullable<String> departamento){
        this.departamento = departamento;
    }
    
}
