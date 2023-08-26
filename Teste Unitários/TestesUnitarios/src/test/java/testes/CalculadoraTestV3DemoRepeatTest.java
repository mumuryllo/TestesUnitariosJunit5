package testes;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testando as principais operações matemáticas!")
class CalculadoraTestV3DemoRepeatTest {

private Calculadora calc;
private Double resultado;

    @BeforeEach
    void iniciando() {
     calc= new Calculadora();
    }

    // () -> roda só caso ocorra falhas
    /*
      testes repetiveis
     * */

    @RepeatedTest(3)
    void naoDeveDividirPorZero(RepetitionInfo repetitionInfo){
        System.out.println("Numero de vezes que o teste foi repetido "+ repetitionInfo.getCurrentRepetition()
        + " " + " de "+ repetitionInfo.getTotalRepetitions() + " vezes "
        );

        String msg = "Não deve dividir por 0!";

        ArithmeticException atual = assertThrows(ArithmeticException.class,()->{
            resultado = calc.divisao(20D,0D);
        },()-> "O segundo número precisa ser 0 para o teste funcionar! ");

      assertEquals(msg,atual.getMessage());

    }
}