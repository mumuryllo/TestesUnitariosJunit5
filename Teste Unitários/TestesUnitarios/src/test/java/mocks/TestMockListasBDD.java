package mocks;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class TestMockListasBDD {

    @Test
    void testandoMockListas(){
        List<?> lista = mock(List.class);
        given(lista.size()).willReturn(10);
        assertThat(lista.size(),is(10));
    }
    @Test
    void testandoMockMultiplosValores(){
        List<?> lista = mock(List.class);
        given(lista.size()).willReturn(10).willReturn(20).willReturn(30);

        assertThat(lista.size(),is(10));
        assertThat(lista.size(),is(20));
        assertThat(lista.size(),is(30));


    }
    @Test
    void testandoMockGets(){
        var lista = mock(List.class);
        given(lista.get(0)).willReturn("Muryllo");

        assertThat(lista.get(0),is("Muryllo"));
    }

    @Test
    void testandoMockArguments(){
        var lista = mock(List.class);
        given(lista.get(anyInt())).willReturn("Muryllo");

        // estou dizendo qualquer inteiro
        assertThat(lista.get(anyInt()),is("Muryllo"));
        assertThat(lista.get(anyInt()),is("Muryllo"));
    }

    @Test
    void testandoMockExceptions(){
        var lista = mock(List.class);
        given(lista.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));

        assertThrows(RuntimeException.class,()->{
            lista.get(anyInt());
        });
    }



}
