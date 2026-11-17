/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.support.it.repository;

import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.entity.TecnicoEntity;
import com.mycompany.support.it.entity.UserEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author guil_dev
 */
public interface CallRepository extends JpaRepository<CallEntity, Integer>{
    
    Page<CallEntity> findAllByUser(UserEntity user, Pageable pageable);
    Page<CallEntity> findAllByStatus(String status, Pageable pageable);
    Page<CallEntity> findAllByTecnico(TecnicoEntity tecnico, Pageable pageable);
    Page<CallEntity> findAll(Pageable pageable);
    
    List<CallEntity> findAllByTecnico(TecnicoEntity tecnico);
    
}
