package testes;

public class Calculadora {
    public Double soma(Double num1, Double num2){
        return  num1+num2;
    }
    public Double subtracao(Double num1, Double num2){
        return  num1-num2;
    }

    public Double multiplicacao(Double num1, Double num2){
        return  num1*num2;
    }
    public Double divisao(Double num1, Double num2){
        if (num2==0) throw new ArithmeticException("Não deve dividir por 0!");
        return  num1/num2;
    }
    public Double media(Double num1, Double num2){
        return  (num1+num2)/2;
    }
    public Double raizQuadrada(Double num){
        return  (Double) Math.sqrt(num);
    }

}
