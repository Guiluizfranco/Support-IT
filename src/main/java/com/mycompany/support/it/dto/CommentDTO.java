/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.dto;

import java.time.LocalDate;

/**
 *
 * @author guil_dev
 */
public class CommentDTO {
    

    private int id;
    private String texto;
    private LocalDate data;
    private Integer userId;
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
    
    public Integer getUser(){
        return userId;
    }
    public void setUser(Integer userId){
        this.userId = userId;
    }
    
    public Integer getCall(){
        return callId;
    }
    public void setCall(Integer callId){
        this.callId = callId; 
    }
    
}
