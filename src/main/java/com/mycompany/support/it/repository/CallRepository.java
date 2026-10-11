/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.support.it.repository;

import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.entity.TecnicoEntity;
import com.mycompany.support.it.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guil_dev
 */
public interface CallRepository extends JpaRepository<CallEntity, Integer>{
    
    List<CallEntity> findAllByUser(UserEntity user);
    List<CallEntity> findAllByStatus(String status);
    List<CallEntity> findAllByTecnico(TecnicoEntity tecnico);
}
