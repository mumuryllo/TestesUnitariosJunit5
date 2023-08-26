package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.User;
import com.example.SpringExemplo.repositories.UserRepository;
import com.example.SpringExemplo.services.exceptions.DatabaseExceptions;
import com.example.SpringExemplo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarUsuarios(){
        return  userRepository.findAll();
    }

    public User listarUsuarioId (Long id){
        Optional<User> obj=userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){

       Optional<User> userSalvo = userRepository.findById(obj.getId());
       if (userSalvo.isPresent()){
           throw new ResourceNotFoundException(
                   "Usuário já existe com esse id:" + obj.getId()
           );
       }



      return   userRepository.save(obj);
    }

    public void  delete(Long id ){
        try {
            if (userRepository.existsById(id)){
                userRepository.deleteById(id);
            }else {
                throw new ResourceNotFoundException(id);
            }
        }catch (DataIntegrityViolationException e){
           throw  new DatabaseExceptions("Tabela não pode ser removida, pois tem ligação com outra!");
        }
    }

    public User update(Long id,User obj){
        try {
            User user = userRepository.getReferenceById(id);
            updateData(user,obj);
            return userRepository.save(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }

}
