package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testando as principais operações matemáticas!")
class CalculadoraTestV2 {

 Calculadora calc;

    @BeforeEach
    void iniciando() {
     calc= new Calculadora();
    }


    /*
    * Testes Com parametros
     * */



    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    @MethodSource()
    void testeDivisaoParametros(double num1,double num2,double result) {

        System.out.println("Test " + num1 + " / " +
                num2 + " = " + result + "!");

        Double actual = calc.divisao(num1, num2);

        assertEquals(result, actual, 2D,
                () -> num1 + "/" + num2 +
                        " did not produce " + result + "!");

    }

    //public static Stream<Arguments> testDivisionInputParameters() {
   public static Stream<Arguments> testeDivisaoParametros(){
        return Stream.of(
                Arguments.of(20D,2D,10D),
                Arguments.of(10D,2D,5D),
                Arguments.of(50D,2D,25D)
        );
    }

}