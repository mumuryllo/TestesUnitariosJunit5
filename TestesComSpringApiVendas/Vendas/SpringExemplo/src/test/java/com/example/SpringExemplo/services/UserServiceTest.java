package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.User;
import com.example.SpringExemplo.repositories.UserRepository;
import com.example.SpringExemplo.services.exceptions.DatabaseExceptions;
import com.example.SpringExemplo.services.exceptions.ResourceNotFoundException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private static User u1,u2;

    @BeforeEach
    void iniciando(){
        u1 = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        u2 = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");
    }

    @Test
    void listarUsuarios() {
        when(repository.findAll()).thenReturn(List.of(u1,u2));
        List<User> userList = service.listarUsuarios();
        assertNotNull(userList);
        assertEquals(2,userList.size());
    }

    @Test
    void listarNenhumUsuario() {
        when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
        List<User> userList = service.listarUsuarios();
        assertTrue(userList.isEmpty());
        assertEquals(0,userList.size());
    }

    @Test
    void listarUsuarioId() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(u1));
        User userOptional = service.listarUsuarioId(u1.getId());
        assertNotNull(userOptional);
        assertEquals("Maria Brown",userOptional.getName());
    }

    @Test
    void testInsertUser() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        when(repository.save(u1)).thenReturn(u1);
        User userSalvo = service.insert(u1);
        assertNotNull(userSalvo);
        assertEquals("Maria Brown",userSalvo.getName());
    }

    @Test
    void insertExistsIdException() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(u1));
        assertThrows(ResourceNotFoundException.class,()->{
            User userSalvo = service.insert(u1);
        });
       verify(repository,never()).save(any(User.class));
    }

    @Test
    void delete() {
    }

    @Test
    void testUpdateUser() {
        u1.setId(1L);
        User updatedUser = new User();
        updatedUser.setName("Jane Smith");
        updatedUser.setEmail("jane@example.com");
        updatedUser.setPhone("987654321");

        when(repository.getReferenceById(u1.getId())).thenReturn(u1);
        when(repository.save(u1)).thenReturn(u1);

        // Act
        User result = service.update(u1.getId(), updatedUser);

        // Assert
        verify(repository).getReferenceById(u1.getId());
        verify(repository).save(u1);

        assertEquals(updatedUser.getName(), result.getName());
        assertEquals(updatedUser.getEmail(), result.getEmail());
        assertEquals(updatedUser.getPhone(), result.getPhone());

    }

    @Test
    public void testUpdateUser_EntityNotFound() {
        // Arrange
        User updatedUser = new User();
        updatedUser.setName("Jane Smith");
        updatedUser.setEmail("jane@example.com");
        updatedUser.setPhone("987654321");

        when(repository.getReferenceById(u1.getId())).thenThrow(new ResourceNotFoundException(u1.getId()));
        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> service.update(u1.getId(), updatedUser));
        verify(repository).getReferenceById(u1.getId());
        verifyNoMoreInteractions(repository);

    }

    @Test
    public void testDeleteUser_Success() {
        // Arrange
        Long userId = 1L;

        when(repository.existsById(userId)).thenReturn(true);

        // Act
        service.delete(userId);

        // Assert
        verify(repository).existsById(userId);
        verify(repository).deleteById(userId);
    }

    @Test
    public void testDeleteUser_EntityNotFound() {
        // Arrange
        Long userId = 1L;

        when(repository.existsById(userId)).thenReturn(false);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> service.delete(userId));
        verify(repository).existsById(userId);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testDeleteUser_DataIntegrityViolation() {
        // Arrange
        Long userId = 1L;

        when(repository.existsById(userId)).thenReturn(true);
        doThrow(new DatabaseExceptions("Violação")).when(repository).deleteById(userId);

        // Act and Assert
        assertThrows(DatabaseExceptions.class, () -> service.delete(userId));
        verify(repository).existsById(userId);
        verify(repository).deleteById(userId);
    }

}