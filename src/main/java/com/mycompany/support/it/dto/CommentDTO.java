/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 *
 * @author guil_dev
 */
public class CommentDTO {
    
    
    private int id;
    
    @NotBlank(message = "É necessário inserir um texto")
    @Size(min=1, max=500)
    private String texto;
    private LocalDate data;
    
    @NotNull(message = "É necessário vincular o comentario a um usuario")
    private Integer userId;
    
    @NotNull(message = "É necessário vincular o comentario a uma chamada")
    private Integer callId;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    
    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    
    public Integer getCallId(){
        return callId;
    }
    public void setCallId(Integer callId){
        this.callId = callId; 
    }
    
}
