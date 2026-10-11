/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.dto;


/**
 *
 * @author guil_dev
 */
public class TecnicoEntityDTO {
    
   
    
    private String nome;
    
    private String email;
   
    private String especialidade;
        
    
    
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
    
   
}
