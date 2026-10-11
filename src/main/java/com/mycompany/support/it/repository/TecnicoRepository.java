/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.support.it.repository;

import com.mycompany.support.it.entity.TecnicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guil_dev
 */
public interface TecnicoRepository extends JpaRepository<TecnicoEntity, Integer>{
    
}
