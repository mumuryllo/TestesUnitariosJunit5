package com.example.SpringExemplo.controllers;

import com.example.SpringExemplo.dto.UserDTO;
import com.example.SpringExemplo.entites.User;
import com.example.SpringExemplo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list= userService.listarUsuarios();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User obj = userService.listarUsuarioId(id);
        return  ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserDTO> insert(@RequestBody User obj){
        obj = userService.insert(obj);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(obj));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
        obj= userService.update(id,obj);
        return  ResponseEntity.status(200).body(obj);
    }

}
