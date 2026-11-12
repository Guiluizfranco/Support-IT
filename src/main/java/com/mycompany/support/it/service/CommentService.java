/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.support.it.service;

import com.mycompany.support.it.dto.CommentDTO;
import com.mycompany.support.it.dto.ResponseDTO;
import com.mycompany.support.it.entity.CallEntity;
import com.mycompany.support.it.entity.CommentEntity;
import com.mycompany.support.it.entity.UserEntity;
import com.mycompany.support.it.repository.CallRepository;
import com.mycompany.support.it.repository.CommentRepository;
import com.mycompany.support.it.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

/**
 *
 * @author guil_dev
 */
@Service
public class CommentService {
    
    private final CommentRepository commentRepository;
    private final CallRepository callRepository;
    private final UserRepository userRepository;
    
    public CommentService(CommentRepository commentRepository,CallRepository callRepository, UserRepository userRepository){
        this.commentRepository = commentRepository;
        this.callRepository = callRepository;
        this.userRepository = userRepository;
    }
    
    ResponseDTO response = new ResponseDTO();
    
    LocalDate today = LocalDate.now();
    
    public ResponseDTO CreateComment(CommentDTO dto){
        
        CommentEntity comment = new CommentEntity();
        
        CallEntity call = callRepository.findById(dto.getCallId()).orElseThrow(() -> new NoSuchElementException("Chamada não encontada"));
        UserEntity user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NoSuchElementException("Usuário não encontado"));
        
        if(call.getDataFechamento() == null){
            
          comment.setTexto(dto.getTexto());
          comment.setLocalDate(today);
          comment.setUser(user);
          comment.setCall(call);
        
          commentRepository.save(comment);
           
          response.setMessage("Comentário inserido!");
            
        }else{
            
          response.setMessage("Não é possível incluir comentário, pois o chamado se encontra fechado!");

        }
        
        return response;

    }
    
    public List SelectAllComments(){
        
        return commentRepository.findAll();

    }
    
    public List SelectCommentsByCall(int id){
        
        CallEntity call = callRepository.findById(id).get();
        
        return commentRepository.findAllByCall(call);
        
    }    
    
    public ResponseDTO AlterTextComment(int id, CommentDTO dto){
        
        CommentEntity comment = commentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Comentario não encontrado"));
        
        comment.setTexto(dto.getTexto());
        commentRepository.save(comment);
        
        response.setMessage("Comentario alterado com sucesso");
        
        return response;
        
    }
}
