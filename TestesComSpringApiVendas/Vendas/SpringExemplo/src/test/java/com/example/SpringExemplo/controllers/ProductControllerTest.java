package com.example.SpringExemplo.controllers;

import com.example.SpringExemplo.entites.Product;
import com.example.SpringExemplo.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Before
    public void iniciando()  {
        p1 = new Product(1L, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        p2 = new Product(2L, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        p3 = new Product(3L, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        p4 = new Product(4L, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        p5 = new Product(5L, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
    }
   private static Product p1,p2,p3,p4,p5;

    @MockBean
    private ProductService service;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void findAll() throws Exception{
        when(service.listarProdutos()).thenReturn(Arrays.asList(p1,p2,p3,p4,p5));
        mockMvc.perform(get("/products").
                        contentType(MediaType.APPLICATION_JSON).
                        content(mapper.writeValueAsString(Arrays.asList(p1,p2,p3,p4,p5)))).
                andDo(print());
        verify(service).listarProdutos();
        verify(service, times(1)).listarProdutos();
    }

    @Test
    public void findById() throws Exception{
        when(service.listarProdutoId(p4.getId())).thenReturn(p4);
        mockMvc.perform(get("/products/{id}", p4.getId()).
                        contentType(MediaType.APPLICATION_JSON).
                        content(mapper.writeValueAsString(p4))).
                andExpect(status().isOk()).
                andDo(print());
    }
}