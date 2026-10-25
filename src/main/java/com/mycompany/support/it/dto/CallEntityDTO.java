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
public class CallEntityDTO {
    
    
    private String titulo;
    private String descricao;
    private String status;
    private LocalDate dataFechamento;
    private int userId;
    private Integer categoryId;
    private Integer tecnicoId;
    
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
    
    public LocalDate getDataFechamento(){
        return dataFechamento;
    }
    public void setDataFechamento(LocalDate dataFechamento){
        this.dataFechamento = dataFechamento;
    }
    
    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    
    public int getCategoryId(){
        return categoryId;
    }
    public void setCatogoryId(Integer categoryId){
        this.categoryId = categoryId;
    }
    
    public Integer getTecnicoId(){
        return tecnicoId;
    }
    public void setTecnicoId(Integer tecnicoId){
        this.tecnicoId = tecnicoId;
    }
        
    
}

