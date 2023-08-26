package mocks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMockListas {

    @Test
    void testandoMockListas(){
        List<?> lista = mock(List.class);
        when(lista.size()).thenReturn(10);

        assertEquals(10,lista.size());
        assertEquals(10,lista.size());
        assertEquals(10,lista.size());
    }
    @Test
    void testandoMockMultiplosValores(){
        List<?> lista = mock(List.class);
        when(lista.size()).thenReturn(10).thenReturn(20).thenReturn(30);

        assertEquals(10,lista.size());
        assertEquals(20,lista.size());
        assertEquals(30,lista.size());
    }
    @Test
    void testandoMockGets(){
        var lista = mock(List.class);
        when(lista.get(0)).thenReturn("Muryllo");

        assertEquals("Muryllo",lista.get(0));
    }

    @Test
    void testandoMockArguments(){
        var lista = mock(List.class);
        when(lista.get(anyInt())).thenReturn("Muryllo");

        // estou dizendo qualquer inteiro
        assertEquals("Muryllo",lista.get(anyInt()));
        assertEquals("Muryllo",lista.get(anyInt()));
    }

    @Test
    void testandoMockExceptions(){
        var lista = mock(List.class);
        when(lista.get(anyInt())).thenThrow(new RuntimeException("Foo Bar"));

        assertThrows(RuntimeException.class,()->{
            lista.get(anyInt());
        });
    }

}
