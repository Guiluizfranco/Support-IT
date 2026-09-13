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
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private int id;
    
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
    
    public Integer getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
}

