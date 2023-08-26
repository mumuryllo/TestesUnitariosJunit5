package testes;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@DisplayName("Testando asserts de arrays!")
public class arraysComparacaoTest {

    @Test
    void testeArrays(){
        int numeros [] = {7,6,5,9,8,10};
        int ordemNumeros[] ={5,6,7,8,9,10};
        Arrays.sort(numeros);
        Assertions.assertArrayEquals(numeros,ordemNumeros);
    }


    // tempo de execução de um teste
    @Test
    @Timeout(value = 15,unit = TimeUnit.MILLISECONDS)
    void testeArraysPerformance(){

        int numeros [] = {7,6,5,9,8,10};

        for (int i = 0; i <10000; i++) {
            numeros[0]=i;
            Arrays.sort(numeros);
        }

    }

}
