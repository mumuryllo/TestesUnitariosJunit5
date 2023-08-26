package testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testando as principais operações matemáticas!")
class CalculadoraTest {

private Calculadora calc;
private Double resultado;

    @BeforeEach
    void iniciando() {
     calc= new Calculadora();
    }

    // () -> roda só caso ocorra falhas
    /*
    * Os testes sempre serão divididos assim
    * Cenário ex -  calc= new Calculadora();
    * Ação ex - calc.soma(1D,5D)
    * Verficação ex - assertEquals(6,resultado, ()-> "Não produziu o resultado esperado!");
     * */

    @Test
    void somaDoisNumeros() {
        resultado = calc.soma(1D,5D);
        assertEquals(6,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(5,resultado);
        assertNotNull(resultado);
    }

    @Test
    void subtracaoDoisNumeros() {
        resultado = calc.subtracao(10D,5D);
        assertEquals(5,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(3,resultado);
        assertNotNull(resultado);
    }

    @Test
    void multiplicacaoDoisNumeros() {
        resultado = calc.multiplicacao(2D,5D);
        assertEquals(10,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(5,resultado);
        assertNotNull(resultado);
    }

    @Test
    void divisaoDoisNumeros() {
        resultado = calc.divisao(20D,2D);
        assertEquals(10,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(5,resultado);
        assertNotNull(resultado);
    }

    @Test
    void mediaDoisNumeros() {
        resultado = calc.media(20D,20D);
        assertEquals(20,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(5,resultado);
        assertNotNull(resultado);
    }

    @Test
    void raizQuadradaDeUmNumero() {
        resultado = calc.raizQuadrada(81D);
        assertEquals(9,resultado, ()-> "Não produziu o resultado esperado!");
        assertNotEquals(5,resultado);
        assertNotNull(resultado);
    }

    @Test
    void naoDeveDividirPorZero(){

        String msg = "Não deve dividir por 0!";

        ArithmeticException atual = assertThrows(ArithmeticException.class,()->{
            resultado = calc.divisao(20D,0D);
        },()-> "O segundo número precisa ser 0 para o teste funcionar! ");

      assertEquals(msg,atual.getMessage());

    }
}