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
@Table(name = "chamado")
public class CallEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String titulo;
    
    @Column
    private String descricao;
    
    @Column
    private String status;
    
    @Column
    private LocalDate dataAbertura;
    
    @Column
    private LocalDate dataFechamento;
    
    @ManyToOne
    @JoinColumn(name = "usuarioAberturaChamado")
    private UserEntity user;
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public LocalDate getDataAbertura(){
        return dataAbertura;
    }
    public void setDataAbertura(LocalDate dataAbertura){
        this.dataAbertura = dataAbertura;
    }
    
    public LocalDate getDataFechamento(){
        return dataFechamento;
    }
    public void setDataFechamento(LocalDate dataFechamento){
        this.dataFechamento = dataFechamento;
    }
    
    public UserEntity getUserEntity(){
        return user;
    }
    public void setUserEntity(UserEntity user){
        this.user = user;
    }
}
