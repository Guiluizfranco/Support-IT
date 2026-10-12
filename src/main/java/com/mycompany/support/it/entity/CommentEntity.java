/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author guil_dev
 */
@Entity
@Table(name = "comentários")
public class CommentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String texto;
    
    @Column
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name ="chamado_id")
    private CallEntity call;
    
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
    
    public LocalDate getLocalDate(){
        return data;
    }
    public void setLocalDate(LocalDate data){
        this.data = data;
    }
    
    public UserEntity getUser(){
        return user;
    }
    public void setUser(UserEntity user){
        this.user = user;
    }
    
    public CallEntity getCall(){
        return call;
    }
    public void setCall(CallEntity call){
        this.call = call; 
    }
    
}
